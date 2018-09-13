package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.ResourceDao;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.Resource;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.ResourceService;
import com.qianxx.qztaxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseService<Resource, ResourceDao> implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public ResourceDao getDao() {
        return resourceDao;
    }

    @Override
    public List<Resource> getAllFather() {
        return resourceDao.getAllFather();
    }

    @Override
    public List<Resource> getSonsByFatherId(Integer fatherId) {
        Map<String, Object> param = new HashMap<>();
        param.put("fatherId", fatherId);
        return resourceDao.getAllByMap(param);
    }
}
