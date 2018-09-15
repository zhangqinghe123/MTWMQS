package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.dao.service.StPptnRDao;
import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.service.StPptnRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.RainFallInfo;
import com.qianxx.qztaxi.vo.StationRainFallInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            while (isContinue) {
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
}
