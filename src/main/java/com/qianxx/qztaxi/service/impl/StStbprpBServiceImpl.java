package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.dao.service.StStbprpBDao;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.po.StStbprpB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/10 15:35
 */
@Service("stStbprpBService")
public class StStbprpBServiceImpl extends BaseService<StStbprpB, StStbprpBDao> implements StStbprpBService {

    @Autowired
    private StStbprpBDao stStbprpBDao;

    @Override
    public StStbprpBDao getDao() {
        return stStbprpBDao;
    }

    @Override
    public List<StStbprpB> getAllRainStations() {
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("STTP", Constants.STATION_TYPE_RAIN);
        return stStbprpBDao.getAllByMap(searchParams);
    }

    @Override
    public List<StStbprpB> getAllReservoirStations() {
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("STTP", Constants.STATION_TYPE_RESERVOIR);
        return stStbprpBDao.getAllByMap(searchParams);
    }

    @Override
    public List<StStbprpB> getAllRiverStations() {
        Map<String, Object> searchParams = new HashMap<>();
        List<StStbprpB> result = new ArrayList<>();

        searchParams.put("STTP", Constants.STATION_TYPE_RIVER);
        List<StStbprpB> riverList = stStbprpBDao.getAllByMap(searchParams);
        if (!CollectionUtils.isEmpty(riverList)) {
            result.addAll(riverList);
        }
        searchParams.put("STTP", Constants.STATION_TYPE_HYDROLOGY);
        List<StStbprpB> hydrologyList = stStbprpBDao.getAllByMap(searchParams);
        if (!CollectionUtils.isEmpty(hydrologyList)) {
            result.addAll(hydrologyList);
        }
        return result;
    }

    @Override
    public List<StStbprpB> getAllMountainTorrentStations() {
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("ATCUNIT", "山洪");
        return stStbprpBDao.getAllByMap(searchParams);
    }

    @Override
    public List<StStbprpB> getAllHydrologyStations() {
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("ATCUNIT", "水文");
        return stStbprpBDao.getAllByMap(searchParams);
    }
}
