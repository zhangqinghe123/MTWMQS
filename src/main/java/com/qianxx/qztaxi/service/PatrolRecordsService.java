package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:29
 */
public interface PatrolRecordsService extends IBaseService<PatrolRecord> {

    DatatableResponse<PatrolRecord> getPageData(HttpServletRequest request);
}
