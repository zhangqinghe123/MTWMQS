package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.vo.AppVersion;
import com.qianxx.qztaxi.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao extends IBaseDao<User> {
    User getByMobile(@Param("mobile") String mobile);
}