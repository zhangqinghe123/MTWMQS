package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.service.StRiverRDao;
import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.service.StRiverRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.RiverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
}
