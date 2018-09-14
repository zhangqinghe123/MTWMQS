package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.PatrolRecordDao;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.PatrolRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("patrolRecordService")
public class PatrolRecordsServiceImpl extends BaseService<PatrolRecord, PatrolRecordDao> implements PatrolRecordsService {

    @Autowired
    private PatrolRecordDao patrolRecordDao;

    @Override
    public PatrolRecordDao getDao() {
        return patrolRecordDao;
    }
}
