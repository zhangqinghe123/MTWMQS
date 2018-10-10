package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.dao.service.StRsvrRDao;
import com.qianxx.qztaxi.po.StRsvrR;
import com.qianxx.qztaxi.po.StStbprpB;
import com.qianxx.qztaxi.service.StRsvrRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.RsvrDetailInfo;
import com.qianxx.qztaxi.vo.RsvrInfo;
import org.apache.commons.lang.time.DateFormatUtils;
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
@Service("stRsvrRService")
public class StRsvrRServiceImpl extends BaseService<StRsvrR, StRsvrRDao> implements StRsvrRService {
    @Autowired
    private StRsvrRDao stRsvrRDao;
    @Autowired
    private StStbprpBService stStbprpBService;

    @Override
    public StRsvrRDao getDao() {
        return stRsvrRDao;
    }

    @Override
    public List<RsvrInfo> getNewestRsvrInfo(String stcds) {
        List<String> staticRiverStations = new ArrayList<>();
        if (StringUtils.isEmpty(stcds)) {
            staticRiverStations = stStbprpBService.getAllRiverStationsSTCD();
        } else {
            staticRiverStations.addAll(Arrays.asList(stcds.split(",")));
        }
        if (CollectionUtils.isEmpty(staticRiverStations)) {
            return null;
        }
        List<RsvrInfo> result = new ArrayList<>();
        for (String stcd : staticRiverStations) {
            List<StRsvrR> estStRiverRList = stRsvrRDao.getNewestRsvrInfo(stcd);
            if (CollectionUtils.isEmpty(estStRiverRList)) {
                continue;
            }
            StRsvrR estStRiverR = estStRiverRList.get(0);
            RsvrInfo rsvrInfo = new RsvrInfo();
            rsvrInfo.setSTCD(stcd);
            rsvrInfo.setCurrentWaterLevel(estStRiverR.getRZ());
            rsvrInfo.setINQ(estStRiverR.getINQ());
            rsvrInfo.setOTQ(estStRiverR.getOTQ());
            rsvrInfo.setCurrentTime(estStRiverR.getTM().getTime());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(estStRiverR.getTM());
            // 当前时间小于8点 显示昨天8点的水情
            if (calendar.get(Calendar.HOUR_OF_DAY) < 8) {
                rsvrInfo.setYesterdayEightClock(true);
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
            calendar.set(Calendar.HOUR_OF_DAY, 8);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            StRsvrR eightClockStRiverR = stRsvrRDao.getRsvrInfoByTime(stcd, calendar.getTime());
            rsvrInfo.setEightClockWaterLevel(eightClockStRiverR.getRZ());
            result.add(rsvrInfo);
        }

        return result;
    }

    @Override
    public List<RsvrDetailInfo> getRsvrInfoByTime(String startTime, String endTime, String stcd) {
        StStbprpB stStbprpB = stStbprpBService.getStationInfoByStcd(stcd);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat paramFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        if (stStbprpB == null) {
            throw new RestServiceException("无站点信息", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        Date startFullTime;
        Date endFullTime;
        try {
            startFullTime = paramFormat.parse(startTime);
            endFullTime = paramFormat.parse(endTime);
            if (endFullTime.getTime() < startFullTime.getTime()) {
                throw new RestServiceException("终止时间需要晚于起始时间。", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        } catch (ParseException e) {
            throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH。", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        List<RsvrDetailInfo> detailInfoList = new ArrayList<>();
        List<StRsvrR> result = stRsvrRDao.getDataBetweenTime(startFullTime, endFullTime, stcd);
        if (!CollectionUtils.isEmpty(result)) {
            for (StRsvrR stRsvrR : result) {
                RsvrDetailInfo rsvrDetailInfo = new RsvrDetailInfo();
                rsvrDetailInfo.setStaticTime(simpleDateFormat.format(stRsvrR.getTM()));
                rsvrDetailInfo.setSTCD(stcd);
                rsvrDetailInfo.setWaterLever(stRsvrR.getRZ() == null ? 0 : stRsvrR.getRZ());
                rsvrDetailInfo.setInWaterFlow(stRsvrR.getINQ() == null ? 0 : stRsvrR.getINQ());
                rsvrDetailInfo.setOutWaterFlow(stRsvrR.getOTQ() == null ? 0 : stRsvrR.getOTQ());
                detailInfoList.add(rsvrDetailInfo);
            }
        }
        return detailInfoList;
    }

//    @Override
//    public List<RsvrDetailInfo> getRsvrInfoByTime(String startTime, String endTime, String stcd) {
//        StStbprpB stStbprpB = stStbprpBService.getStationInfoByStcd(stcd);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat paramFormat = new SimpleDateFormat("yyyy-MM-dd HH");
//        Calendar calendar = Calendar.getInstance();
//        if (stStbprpB == null) {
//            throw new RestServiceException("无站点信息", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
//        }
//        try {
//            if (paramFormat.parse(endTime).getTime() < paramFormat.parse(startTime).getTime()) {
//                throw new RestServiceException("终止时间需要晚于起始时间", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
//            }
//        } catch (ParseException e) {
//            throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
//        }
//        List<RsvrDetailInfo> detailInfoList = new ArrayList<>();
//        while (true) {
//            RsvrDetailInfo rsvrDetailInfo = new RsvrDetailInfo();
//            try {
//                rsvrDetailInfo.setStaticTime(startTime);
//                rsvrDetailInfo.setSTCD(stcd);
//
//                String startStr = startTime + ":00:00";
//                String endTimeStr = startTime + ":59:59";
//
//                Date startFullTime = simpleDateFormat.parse(startStr);
//                Date endFullTime = simpleDateFormat.parse(endTimeStr);
//                Map<String, Object> avgResult = stRsvrRDao.getInfoBetweenTime(startFullTime, endFullTime, stcd);
//                if (avgResult != null) {
//                    BigDecimal RZ_AVG = avgResult.get("RZ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("RZ_AVG");
//                    BigDecimal INQ_AVG = avgResult.get("INQ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("INQ_AVG");
//                    BigDecimal OTQ_AVG = avgResult.get("OTQ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("OTQ_AVG");
//                    rsvrDetailInfo.setWaterLever(CommonUtils.setDoubleScale(RZ_AVG, 2));
//                    rsvrDetailInfo.setInWaterFlow(CommonUtils.setDoubleScale(INQ_AVG, 2));
//                    rsvrDetailInfo.setOutWaterFlow(CommonUtils.setDoubleScale(OTQ_AVG, 2));
//                    detailInfoList.add(rsvrDetailInfo);
//                }
//                calendar.setTime(startFullTime);
//                calendar.add(Calendar.HOUR_OF_DAY, 1);
//                calendar.set(Calendar.MINUTE, 0);
//                calendar.set(Calendar.SECOND, 0);
//                calendar.set(Calendar.MILLISECOND, 0);
//                if (paramFormat.parse(endTime).getTime() < calendar.getTimeInMillis()) {
//                    break;
//                }
//                if (calendar.getTimeInMillis() > new Date().getTime()) {
//                    break;
//                }
//
//                startTime = paramFormat.format(calendar.getTime());
//            } catch (ParseException e) {
//                throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
//            }
//        }
//        return detailInfoList;
//    }

    @Override
    public List<RsvrDetailInfo> getRsvrInfoList() {
        List<StStbprpB> staticRiverStations = stStbprpBService.getAllReservoirStations();
        List<RsvrDetailInfo> result = new ArrayList<>();
        for (StStbprpB stcd : staticRiverStations) {
            List<StRsvrR> estStRiverRList = stRsvrRDao.getNewestRsvrInfo(stcd.getSTCD());
            if (CollectionUtils.isEmpty(estStRiverRList)) {
                continue;
            }
            StRsvrR estStRiverR = estStRiverRList.get(0);
            RsvrDetailInfo rsvrInfo = new RsvrDetailInfo();
            rsvrInfo.setSTCD(stcd.getSTCD());
            rsvrInfo.setName(stcd.getSTNM());
            rsvrInfo.setStaticTime(DateFormatUtils.format(estStRiverR.getTM(), "MM-dd HH:mm"));
            if (estStRiverR.getRZ() != null) {
                rsvrInfo.setWaterLever(estStRiverR.getRZ());
            }
            if (estStRiverR.getINQ() != null) {
                rsvrInfo.setInWaterFlow(estStRiverR.getINQ());
            }
            if (estStRiverR.getOTQ() != null) {
                rsvrInfo.setOutWaterFlow(estStRiverR.getOTQ());
            }
            if (estStRiverRList.size() == 2) {
                int compareResult = estStRiverRList.get(0).getRZ().compareTo(estStRiverRList.get(1).getRZ());
                if (compareResult > 0) {
                    rsvrInfo.setUpAndDownStatus(RsvrDetailInfo.UpAndDownStatus.UP);
                } else if (compareResult < 0) {
                    rsvrInfo.setUpAndDownStatus(RsvrDetailInfo.UpAndDownStatus.DOWN);
                } else {
                    rsvrInfo.setUpAndDownStatus(RsvrDetailInfo.UpAndDownStatus.HOLD_LINE);
                }
            } else {
                rsvrInfo.setUpAndDownStatus(RsvrDetailInfo.UpAndDownStatus.HOLD_LINE);
            }
            if (estStRiverR.getW() != null) {
                rsvrInfo.setCapacity(estStRiverR.getW());
            }
            result.add(rsvrInfo);
        }

        return result;
    }

    @Override
    public List<RsvrDetailInfo> getEightRsvrInfoByTime(String startTime, String endTime, String stcd) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StStbprpB stStbprpB = stStbprpBService.getStationInfoByStcd(stcd);
        SimpleDateFormat paramFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        if (stStbprpB == null) {
            throw new RestServiceException("无站点信息", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        try {
            if (paramFormat.parse(endTime).getTime() < paramFormat.parse(startTime).getTime()) {
                throw new RestServiceException("终止时间需要晚于起始时间", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        } catch (ParseException e) {
            throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
        }
        List<RsvrDetailInfo> detailInfoList = new ArrayList<>();
        while (true) {
            RsvrDetailInfo rsvrDetailInfo = new RsvrDetailInfo();
            try {
                rsvrDetailInfo.setStaticTime(startTime.substring(startTime.indexOf("-") + 1) + " 08:00");
                rsvrDetailInfo.setSTCD(stcd);

                String startStr = startTime + " 08:00:00";
                Date startFullTime = simpleDateFormat.parse(startStr);
                Map<String, Object> avgResult = stRsvrRDao.getInfoBetweenTime(startFullTime, startFullTime, stcd);
                if (avgResult != null) {
                    BigDecimal RZ_AVG = avgResult.get("RZ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("RZ_AVG");
                    BigDecimal INQ_AVG = avgResult.get("INQ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("INQ_AVG");
                    BigDecimal OTQ_AVG = avgResult.get("OTQ_AVG") == null ? new BigDecimal("0") : (BigDecimal) avgResult.get("OTQ_AVG");
                    rsvrDetailInfo.setInWaterFlow(CommonUtils.setDoubleScale(INQ_AVG, 2));
                    rsvrDetailInfo.setWaterLever(CommonUtils.setDoubleScale(RZ_AVG, 2));
                    rsvrDetailInfo.setOutWaterFlow(CommonUtils.setDoubleScale(OTQ_AVG, 2));
                    detailInfoList.add(rsvrDetailInfo);
                }
                calendar.setTime(startFullTime);
                if (paramFormat.parse(endTime).getTime() < calendar.getTimeInMillis()) {
                    break;
                }
                if (calendar.getTimeInMillis() > new Date().getTime()) {
                    break;
                }
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                startTime = paramFormat.format(calendar.getTime());
            } catch (ParseException e) {
                throw new RestServiceException("时间戳格式不正确,请使用格式yyyy-MM-dd HH", ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
        }

        return detailInfoList;
    }
}
