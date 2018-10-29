package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.PatrolRecordDao;
import com.qianxx.qztaxi.dao.user.PatrolTypeDictionaryDao;
import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.po.PatrolTypeDictionary;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.PatrolRecordsService;
import com.qianxx.qztaxi.service.PatrolTypeDictionaryService;
import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.webService.adminuser.BaseController;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:31
 */
@Service("patrolTypeDictionaryService")
public class PatrolTypeDictionaryServiceImpl extends BaseService<PatrolTypeDictionary, PatrolTypeDictionaryDao> implements PatrolTypeDictionaryService {

    @Autowired
    private PatrolTypeDictionaryDao patrolTypeDictionaryDao;

    @Override
    public PatrolTypeDictionaryDao getDao() {
        return patrolTypeDictionaryDao;
    }
}
