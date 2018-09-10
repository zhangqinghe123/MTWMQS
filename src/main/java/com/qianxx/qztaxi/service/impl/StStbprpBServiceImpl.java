package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.service.AppVersionDao;
import com.qianxx.qztaxi.dao.service.StStbprpBDao;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.StStbprpB;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/10 15:35
 */
public class StStbprpBServiceImpl extends BaseService<StStbprpB, StStbprpBDao> implements StStbprpBService {

    @Autowired
    private StStbprpBDao stStbprpBDao;

    @Override
    public StStbprpBDao getDao() {
        return stStbprpBDao;
    }
}
