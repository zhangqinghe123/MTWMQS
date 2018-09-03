package com.qianxx.qztaxi.webService.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;

/**
 * 描述： <br>
 * Created on 2016/4/29. <br>
 *
 * @author zhangjie
 */
public class BaseController {

	protected DatatableRequest getRequest(HttpServletRequest request) {
		DatatableRequest datatableRequest = new DatatableRequest();
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		datatableRequest.setDraw(draw == null ? 0 : Integer.parseInt(draw));
		datatableRequest.setLength(length == null ? 10 : Integer.parseInt(length));
		datatableRequest.setStart(start == null ? 0 : Integer.parseInt(start));
		datatableRequest.setSearchValue(request.getParameter("search[value]"));
		Map<String, Object> searchMap = datatableRequest.getSearchMap();
		searchMap.put("start", Integer.parseInt(start));
		searchMap.put("length", Integer.parseInt(length));
		return datatableRequest;

	}

	protected Integer getCompanyId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("companyId") == null) {
			return null;
		}
		Integer companyId = Integer.parseInt(session.getAttribute("companyId").toString());
		return companyId;
	}

	protected Integer getAdminId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminId") == null)
			throw new NullPointerException();
		Integer adminId = Integer.parseInt(session.getAttribute("adminId").toString());
		return adminId;
	}

	protected String getAdminName(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null)
			throw new NullPointerException();
		String name = session.getAttribute("name").toString();
		return name;
	}

}