package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.dao.service.StPptnRDao;
import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.service.StPptnRService;
import com.qianxx.qztaxi.vo.PlaneRainFallInfo;
import com.qianxx.qztaxi.vo.RainFallInfo;
import com.qianxx.qztaxi.vo.RiverDetailInfo;
import com.qianxx.qztaxi.vo.StationRainFallInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("stPptnRService")
public class StPptnRServiceImpl extends BaseService<StPptnR, StPptnRDao> implements StPptnRService {

    @Autowired
    private StPptnRDao stPptnRDao;

    @Override
    public StPptnRDao getDao() {
        return stPptnRDao;
    }

    @Override
    public List<StationRainFallInfo> getRainfallInfoByTime(Long startTime, Long endTime, Integer interval, String stcds) {
        long intervalMillisValue = interval * 3600000;
        List<StationRainFallInfo> result = new ArrayList<>();
        String[] stcdList = stcds.split(",");
        for (String stcd : stcdList) {
            StationRainFallInfo stationRainFallInfo = new StationRainFallInfo();
            stationRainFallInfo.setSTCD(stcd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(startTime);
            boolean isContinue = true;
            while (true) {
                RainFallInfo rainFallInfo = new RainFallInfo();
                rainFallInfo.setStartTime(calendar.getTimeInMillis());
                long calculateEnd = calendar.getTimeInMillis() + intervalMillisValue;
                if (calculateEnd > endTime) {
                    calculateEnd = endTime;
                    isContinue = false;
                } else {
                    calculateEnd = calculateEnd - 1;
                }
                rainFallInfo.setEndTime(calculateEnd);
                Map<String, Object> resultMap = stPptnRDao.getRainInfoByTime(stcd, new Date(rainFallInfo.getStartTime()), new Date(rainFallInfo.getEndTime()));
                if (resultMap != null) {
                    BigDecimal totalRainFall = resultMap.get("DRP_SUM") == null ? new BigDecimal("0") : (BigDecimal) resultMap.get("DRP_SUM");
                    BigDecimal totalTime = resultMap.get("INTV_SUM") == null ? new BigDecimal("0") : (BigDecimal) resultMap.get("INTV_SUM");
                    rainFallInfo.setDRP_SUM(totalRainFall.doubleValue());
                    rainFallInfo.setINTV_SUM(totalTime.doubleValue());
                    stationRainFallInfo.addTotalRainFall(CommonUtils.setDoubleScale(totalRainFall, 1));
                } else {
                    rainFallInfo.setDRP_SUM(0D);
                    rainFallInfo.setINTV_SUM(0D);
                }
                // 总降水量
                // 总降水时长
                stationRainFallInfo.getRainFallInfos().add(rainFallInfo);
                if (!isContinue) {
                    break;
                }
                calendar.setTimeInMillis(rainFallInfo.getEndTime() + 1L);
            }
            result.add(stationRainFallInfo);
        }

        return result;
    }

    @Override
    public double getNewAvgRainfallInfo() {
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        Date startTime = calendar.getTime();
        Map<String, Object> resultMap = stPptnRDao.getAvgRainfallInfo(startTime, endTime);
        if (resultMap != null) {
            return CommonUtils.setDoubleScale((BigDecimal) resultMap.get("AVG_DRP"), 1);
        }
        return 0;
    }

    @Override
    public Integer getRainfallGt50Num() {
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        Date startTime = calendar.getTime();
        return stPptnRDao.getRainfallGt50Num(startTime, endTime);
    }

    @Override
    public List<PlaneRainFallInfo> getPlaneRainfallByTime(String startTime, String endTime) {
        SimpleDateFormat paramFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            if (paramFormat.parse(endTime).getTime() < paramFormat.parse(startTime).getTime()) {
                throw new RestServiceException("终止时间需要晚于起始时间", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        } catch (ParseException e) {
            throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }

        List<PlaneRainFallInfo> result = new ArrayList<>();

        while (true) {
            PlaneRainFallInfo planeRainFallInfo = new PlaneRainFallInfo();
            try {
                planeRainFallInfo.setStaticTime(startTime);
                String startStr = startTime + " 00:00:00";
                String endTimeStr = startTime + " 23:59:59";
                Date startFullTime = simpleDateFormat.parse(startStr);
                Date endFullTime = simpleDateFormat.parse(endTimeStr);
                Map<String, Object> avgResult = stPptnRDao.getAvgRainfallInfo(startFullTime, endFullTime);
                if (avgResult != null) {
                    BigDecimal avg_drp = avgResult.get("AVG_DRP") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("AVG_DRP");
                    planeRainFallInfo.setDRP_SUM(CommonUtils.setDoubleScale(avg_drp, 2));
                    result.add(planeRainFallInfo);
                }
                calendar.setTime(startFullTime);
                calendar.add(Calendar.DAY_OF_MONTH, 1);
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
                throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        }
        return result;
    }
}
