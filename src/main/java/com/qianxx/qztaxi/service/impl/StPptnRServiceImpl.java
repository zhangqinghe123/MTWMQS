package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.dao.service.StPptnRDao;
import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.po.StStbprpB;
import com.qianxx.qztaxi.service.StPptnRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private StStbprpBService stStbprpBService;

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
        calendar.add(Calendar.DAY_OF_MONTH, -1);
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
        calendar.add(Calendar.DAY_OF_MONTH, -1);
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
                if (paramFormat.parse(endTime).getTime() < calendar.getTimeInMillis()) {
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

    @Override
    public RealTimeRainInfo getRealTimeRainStaticInfo(Long startTime, Long endTime) {
        RealTimeRainInfo result = new RealTimeRainInfo();
        List<StStbprpB> allRainStations = stStbprpBService.getAllRainStations();
        result.setTotalStationNum(allRainStations.size());
        int rainStationNum = 0;
        double maxRainfall = 0d;
        String maxRainStationName = "";
        String maxRainStationSTCD = "";
        List<RainFallLevel> rainFallLevelList = new ArrayList<>();

        RainFallLevel level1 = new RainFallLevel();
        level1.setLevelName(">=250");
        RainFallLevel level2 = new RainFallLevel();
        level2.setLevelName("100 ~ 250");
        RainFallLevel level3 = new RainFallLevel();
        level3.setLevelName("50 ~ 100");
        RainFallLevel level4 = new RainFallLevel();
        level4.setLevelName("25 ~ 50");
        RainFallLevel level5 = new RainFallLevel();
        level5.setLevelName("10 ~ 25");
        RainFallLevel level6 = new RainFallLevel();
        level6.setLevelName("0 ~ 10");

        if (!CollectionUtils.isEmpty(allRainStations)) {
            for (StStbprpB station : allRainStations) {
                Map<String, Object> resultMap = stPptnRDao.getRainInfoByTime(station.getSTCD(), new Date(startTime), new Date(endTime));
                if (resultMap != null) {
                    BigDecimal totalRainFall = resultMap.get("DRP_SUM") == null ? new BigDecimal("0") : (BigDecimal) resultMap.get("DRP_SUM");
                    double totalRainFallD = CommonUtils.setDoubleScale(totalRainFall, 1);
                    if (totalRainFallD == 0) {
                        continue;
                    }
                    if (totalRainFallD > maxRainfall) {
                        // 设置最大降雨量
                        maxRainfall = totalRainFallD;
                        maxRainStationSTCD = station.getSTCD();
                        maxRainStationName = station.getSTNM();
                    }
                    setRainLevel(level1, level2, level3, level4, level5, level6, station, totalRainFallD);
                    if (totalRainFallD > 0) {
                        rainStationNum++;
                    }
                }
            }
        }
        rainFallLevelList.add(level1);
        rainFallLevelList.add(level2);
        rainFallLevelList.add(level3);
        rainFallLevelList.add(level4);
        rainFallLevelList.add(level5);
        rainFallLevelList.add(level6);

        result.setRainStationNum(rainStationNum);
        result.setMaxRainfall(maxRainfall);
        result.setMaxRainStationSTCD(maxRainStationSTCD);
        result.setMaxRainStationName(maxRainStationName);
        result.setRainFallLevel(rainFallLevelList);
        return result;
    }

    @Override
    public List<StationRainInfo> getRealTimeRainStationList(Long startTime, Long endTime, Boolean needNoRainStation) {
        List<StationRainInfo> result = new ArrayList<>();
        List<StStbprpB> allRainStations = stStbprpBService.getAllRainStations();

        if (!CollectionUtils.isEmpty(allRainStations)) {
            for (StStbprpB station : allRainStations) {
                Map<String, Object> resultMap = stPptnRDao.getRainInfoByTime(station.getSTCD(), new Date(startTime), new Date(endTime));
                if (resultMap != null) {
                    BigDecimal totalRainFall = resultMap.get("DRP_SUM") == null ? new BigDecimal("0") : (BigDecimal) resultMap.get("DRP_SUM");
                    double totalRainFallD = CommonUtils.setDoubleScale(totalRainFall, 1);
                    if (!needNoRainStation && totalRainFallD == 0) {
                        continue;
                    }
                    StationRainInfo stationRainInfo = new StationRainInfo();
                    stationRainInfo.setStcd(station.getSTCD());
                    stationRainInfo.setName(station.getSTNM());
                    stationRainInfo.setLatitude(station.getLGTD());
                    stationRainInfo.setLongitude(station.getLTTD());
                    stationRainInfo.setRainfall(totalRainFallD);
                    result.add(stationRainInfo);
                }
            }
        }
        return result;
    }

    private void setRainLevel(RainFallLevel level1, RainFallLevel level2, RainFallLevel level3, RainFallLevel level4, RainFallLevel level5, RainFallLevel level6, StStbprpB station, double totalRainFallD) {
        StationRainInfo stationRainInfo = new StationRainInfo();
        stationRainInfo.setLatitude(station.getLGTD());
        stationRainInfo.setLongitude(station.getLTTD());
        stationRainInfo.setName(station.getSTNM());
        stationRainInfo.setStcd(station.getSTCD());
        stationRainInfo.setRainfall(totalRainFallD);
        if (totalRainFallD >= 250) {
            level1.setStationNum(level1.getStationNum() + 1);
            level1.getStationRainInfos().add(stationRainInfo);
        } else if (totalRainFallD >= 100 && totalRainFallD < 250) {
            level2.setStationNum(level2.getStationNum() + 1);
            level2.getStationRainInfos().add(stationRainInfo);
        } else if (totalRainFallD >= 50 && totalRainFallD < 100) {
            level3.setStationNum(level3.getStationNum() + 1);
            level3.getStationRainInfos().add(stationRainInfo);
        } else if (totalRainFallD >= 25 && totalRainFallD < 50) {
            level4.setStationNum(level4.getStationNum() + 1);
            level4.getStationRainInfos().add(stationRainInfo);
        } else if (totalRainFallD >= 10 && totalRainFallD < 25) {
            level5.setStationNum(level5.getStationNum() + 1);
            level5.getStationRainInfos().add(stationRainInfo);
        } else if (totalRainFallD > 0 && totalRainFallD < 10) {
            level6.setStationNum(level6.getStationNum() + 1);
            level6.getStationRainInfos().add(stationRainInfo);
        }
    }
}
