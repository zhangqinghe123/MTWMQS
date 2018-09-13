package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.AdminUserDao;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.AdminUser;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.AdminUserService;
import com.qianxx.qztaxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("adminUserService")
public class AdminUserServiceImpl extends BaseService<AdminUser, AdminUserDao> implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public AdminUserDao getDao() {
        return adminUserDao;
    }
}
