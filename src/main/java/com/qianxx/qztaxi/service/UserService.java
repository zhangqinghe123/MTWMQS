package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.User;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:29
 */
public interface UserService extends IBaseService<User> {
    User getByMobile(String mobile);
}
