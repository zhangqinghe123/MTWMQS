package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.dao.service.StStbprpBDao;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.po.StStbprpB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StStbprpB> getAllRainStations(Integer pageSize, Integer pageNum) {
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("STTP", Constants.STATION_TYPE_RAIN);
        searchParams.put("start", pageSize * pageNum);
        searchParams.put("length", pageNum);
        return stStbprpBDao.getAllByMap(searchParams);
    }
}
