package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.dao.service.StRiverRDao;
import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.po.StStbprpB;
import com.qianxx.qztaxi.service.StRiverRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.RiverDetailInfo;
import com.qianxx.qztaxi.vo.RiverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/11 16:02
 */
@Service("stRiverRService")
public class StRiverRServiceImpl extends BaseService<StRiverR, StRiverRDao> implements StRiverRService {
    @Autowired
    private StRiverRDao stRiverRDao;
    @Autowired
    private StStbprpBService stStbprpBService;

    @Override
    public StRiverRDao getDao() {
        return stRiverRDao;
    }

    @Override
    public List<RiverInfo> getNewestRiverInfo(String stcds) {
        List<String> staticRiverStations = new ArrayList<>();
        if (StringUtils.isEmpty(stcds)) {
            staticRiverStations = stStbprpBService.getAllRiverStationsSTCD();
        } else {
            staticRiverStations.addAll(Arrays.asList(stcds.split(",")));
        }
        if (CollectionUtils.isEmpty(staticRiverStations)) {
            return null;
        }
        List<RiverInfo> result = new ArrayList<>();
        for (String stcd : staticRiverStations) {
            StRiverR estStRiverR = stRiverRDao.getNewestRiverInfo(stcd);
            if (estStRiverR == null) {
                continue;
            }
            RiverInfo riverInfo = new RiverInfo();
            riverInfo.setSTCD(stcd);
            riverInfo.setCurrentWaterLevel(estStRiverR.getZ());
            riverInfo.setCurrentTime(estStRiverR.getTM().getTime());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(estStRiverR.getTM());
            // 当前时间小于8点 显示昨天8点的水情
            if (calendar.get(Calendar.HOUR_OF_DAY) < 8) {
                riverInfo.setYesterdayEightClock(true);
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
            calendar.set(Calendar.HOUR_OF_DAY, 8);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            StRiverR eightClockStRiverR = stRiverRDao.getRiverInfoByTime(stcd, calendar.getTime());
            riverInfo.setEightClockWaterLevel(eightClockStRiverR.getZ());
            result.add(riverInfo);
        }

        return result;
    }

    @Override
    public List<RiverDetailInfo> getRiverInfoByTime(String startTime, String endTime, String stcd) {
        StStbprpB stStbprpB = stStbprpBService.getStationInfoByStcd(stcd);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat paramFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar calendar = Calendar.getInstance();
        if (stStbprpB == null) {
            throw new RestServiceException("无站点信息", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        try {
            if (paramFormat.parse(endTime).getTime() < paramFormat.parse(startTime).getTime()) {
                throw new RestServiceException("终止时间需要晚于起始时间", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        } catch (ParseException e) {
            throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        List<RiverDetailInfo> detailInfoList = new ArrayList<>();

        while (true) {
            RiverDetailInfo riverDetailInfo = new RiverDetailInfo();
            try {
                riverDetailInfo.setStaticTime(startTime);
                riverDetailInfo.setSTCD(stcd);
                String startStr = startTime + ":00:00";
                String endTimeStr = startTime + ":59:59";
                Date startFullTime = simpleDateFormat.parse(startStr);
                Date endFullTime = simpleDateFormat.parse(endTimeStr);
                Map<String, Object> avgResult = stRiverRDao.getInfoBetweenTime(startFullTime, endFullTime, stcd);
                if (avgResult != null) {
                    BigDecimal q_avg = avgResult.get("Q_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("Q_AVG");
                    BigDecimal z_avg = avgResult.get("Z_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("Z_AVG");
                    riverDetailInfo.setWaterFlow(CommonUtils.setDoubleScale(q_avg, 2));
                    riverDetailInfo.setWaterLever(CommonUtils.setDoubleScale(z_avg, 2));
                    detailInfoList.add(riverDetailInfo);
                }
                calendar.setTime(startFullTime);
                calendar.add(Calendar.HOUR_OF_DAY, 1);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if (paramFormat.parse(endTime).getTime() <= calendar.getTimeInMillis()) {
                    break;
                }
                if (calendar.getTimeInMillis() > new Date().getTime()) {
                    break;
                }
                startTime = paramFormat.format(calendar.getTime());
            } catch (ParseException e) {
                throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        }

        return detailInfoList;
    }
}
