package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.UserDao;
import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByMobile(String mobile) {
        return userDao.getByMobile(mobile);
    }

    @Override
    public UserDao getDao() {
        return userDao;
    }
}
