package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.Resource;
import com.qianxx.qztaxi.po.UserInfo;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:29
 */
public interface ResourceService extends IBaseService<Resource> {

    List<Resource> getAllFather();

    List<Resource> getSonsByFatherId(Integer fatherId);
}
