package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends IBaseDao<User> {
    User getByMobile(@Param("mobile") String mobile);
}