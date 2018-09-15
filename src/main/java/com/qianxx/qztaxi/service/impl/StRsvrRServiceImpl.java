package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.service.StRiverRDao;
import com.qianxx.qztaxi.dao.service.StRsvrRDao;
import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.po.StRsvrR;
import com.qianxx.qztaxi.service.StRsvrRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.RiverInfo;
import com.qianxx.qztaxi.vo.RsvrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
            StRsvrR estStRiverR = stRsvrRDao.getNewestRsvrInfo(stcd);
            if (estStRiverR == null) {
                continue;
            }
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
}
