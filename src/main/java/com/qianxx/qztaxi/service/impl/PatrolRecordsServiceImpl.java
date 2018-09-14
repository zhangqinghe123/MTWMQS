package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.dao.user.PatrolRecordDao;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.PatrolRecordsService;
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
@Service("patrolRecordService")
public class PatrolRecordsServiceImpl extends BaseService<PatrolRecord, PatrolRecordDao> implements PatrolRecordsService {

    @Autowired
    private PatrolRecordDao patrolRecordDao;
    @Autowired
    private UserService userService;

    @Override
    public PatrolRecordDao getDao() {
        return patrolRecordDao;
    }

    @Override
    public DatatableResponse<PatrolRecord> getPageData(HttpServletRequest request) {
        DatatableRequest datatableRequest = BaseController.getDatatableRequest(request);
        DatatableResponse<PatrolRecord> response = new DatatableResponse<>();
        datatableRequest.getSearchMap().put("userId", request.getParameter("userId"));
        List<PatrolRecord> pageDate = patrolRecordDao.getPage(datatableRequest.getSearchMap());
        for (PatrolRecord p : pageDate) {
            UserInfo userInfo = userService.getById(p.getUserId());
            if (userInfo != null) {
                p.setUserName(userInfo.getUserName());
                p.setUserMobile(userInfo.getMobile());
            }
        }
        response.setData(pageDate);
        response.setRecordsTotal(patrolRecordDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
        return response;
    }
}
