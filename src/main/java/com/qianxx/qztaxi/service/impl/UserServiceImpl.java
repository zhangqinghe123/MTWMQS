package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("userService")
public class UserServiceImpl extends BaseService<UserInfo, UserInfoDao> implements UserService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoDao getDao() {
        return userInfoDao;
    }
}
