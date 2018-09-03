package com.qianxx.qztaxi.webService.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.qianxx.qztaxi.common.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianxx.qztaxi.dao.AppVersionDao;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.vo.AppVersion;
import com.qianxx.qztaxi.webService.response.AjaxList;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("admin/version")
@ApiIgnore
public class VersionController extends BaseController {

	@Autowired
	private AppVersionService appVersionService;

	@Autowired
	private AppVersionDao appVersionDao;

	@RequestMapping("")
	public String index() {
		return "version/index";
	}

	@RequestMapping(value = "getVersionList", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponse<AppVersion> getVersionList(HttpServletRequest request) {
		DatatableRequest datatableRequest = getRequest(request);
		datatableRequest.getSearchMap().put("terminal", request.getParameter("terminal"));
		DatatableResponse<AppVersion> response = new DatatableResponse<AppVersion>();
        response.setData(appVersionDao.getPage(datatableRequest.getSearchMap()));
        response.setRecordsTotal(appVersionDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
		return response;
	}

	@RequestMapping("doUpdateState")
	@ResponseBody
	public AjaxList doUpdateState(Integer versionId) {
		if(versionId == null || versionId.compareTo(1) < 0)
			return AjaxList.createError("参数错误", null);
		AppVersion appVersion = appVersionService.getById(versionId);
		if(appVersion == null)
			return AjaxList.createError("您选择的记录不存在", null);
		appVersionService.doUpdateState(versionId);
		return AjaxList.createSuccess("操作成功", null);
	}

	@RequestMapping("add")
	public String add() {
		return "version/add";
	}

	@RequestMapping("doAdd")
	@ResponseBody
	public AjaxList doAdd(AppVersion appVersion) {
		AjaxList ajaxList = validate(appVersion, true);
		if(!ajaxList.getStatus().equals(Constants.API_STATUS_SUCCESS))
			return ajaxList;
		long count = appVersionService.getVersionByCode(null, appVersion.getVersionCode(), appVersion.getTerminal());
		if(count > 0)
			return AjaxList.createError("版本号【" + appVersion.getVersionCode() + "】已存在，请重新输入", null);
		appVersion.setCtime(new Date());
		appVersionService.doInsert(appVersion);
		return AjaxList.createSuccess("保存成功", null);
	}

	@RequestMapping("update")
	public String update(Model model, Integer versionId) {
		model.addAttribute("appVersion", appVersionService.getById(versionId));
		return "version/update";
	}

	@RequestMapping("view")
	public String view(Model model, Integer versionId) {
		model.addAttribute("appVersion", appVersionService.getById(versionId));
		return "version/view";
	}

	@RequestMapping("doUpdate")
	@ResponseBody
	public AjaxList doUpdate(AppVersion appVersion) {
		if(appVersion.getVersionId() == null || appVersion.getVersionId().compareTo(1) < 0)
			return AjaxList.createError("参数错误", null);
		AjaxList ajaxList = validate(appVersion, false);
		if(!ajaxList.getStatus().equals(Constants.API_STATUS_SUCCESS))
			return ajaxList;
		long count = appVersionService.getVersionByCode(appVersion.getVersionId(), appVersion.getVersionCode(), appVersion.getTerminal());
		if(count > 0)
			return AjaxList.createError("版本号【" + appVersion.getVersionCode() + "】已存在，请重新输入", null);
		appVersionService.doUpdate(appVersion);
		return AjaxList.createSuccess("编辑成功", null);
	}

	/**
	 * 新增、编辑校验
	 */
	private AjaxList validate(AppVersion appVersion, boolean tag) {
		if(StringUtils.isBlank(appVersion.getVersionName()))
			return AjaxList.createError("请输入版本名称", null);
		else if(appVersion.getVersionName().length() > 20)
			return AjaxList.createError("版本名称长度不能超过20个字符", null);
		if(StringUtils.isBlank(appVersion.getVersionCode()))
			return AjaxList.createError("请输入版本号", null);
		else if(appVersion.getVersionCode().length() > 20)
			return AjaxList.createError("版本号长度不能超过20个字符", null);
		if(StringUtils.isBlank(appVersion.getMd5()))
			return AjaxList.createError("请输入MD5校验码", null);
		else if(appVersion.getMd5().length() > 40)
			return AjaxList.createError("MD5校验码不能超过40个字符", null);
		if(appVersion.getTerminal() == null)
			return AjaxList.createError("请选择终端类型", null);
		else if(!appVersion.getTerminal().equals(1) && !appVersion.getTerminal().equals(2))
			return AjaxList.createError("请选择终端类型", null);
		if(appVersion.getVersionType() == null)
			return AjaxList.createError("请选择更新类型", null);
		else if(!appVersion.getVersionType().equals(1) && !appVersion.getVersionType().equals(2))
			return AjaxList.createError("请选择更新类型", null);
		if(StringUtils.isBlank(appVersion.getDownLoadUrl()))
			return AjaxList.createError("请填写下载地址", null);
		else if(appVersion.getDownLoadUrl().length() > 400)
			return AjaxList.createError("下载地址长度不能超过400个字符", null);
		if(StringUtils.isBlank(appVersion.getIntroduce()))
			return AjaxList.createError("请填写版本介绍", null);
		else if(appVersion.getIntroduce().length() > 200)
			return AjaxList.createError("版本介绍长度不能超过200个字符", null);
		if(StringUtils.isNotBlank(appVersion.getPurpose()) && appVersion.getPurpose().length() > 150)
			return AjaxList.createError("用途长度不能超过150个字符", null);
		else
			appVersion.setPurpose("");
		return AjaxList.createSuccess("成功", null);
	}

	@RequestMapping("doDelete")
	@ResponseBody
	public AjaxList doDelete(Integer versionId) {
		if(versionId == null || versionId < 1)
			return AjaxList.createError("参数错误", null);
		AppVersion appVersion = appVersionService.getById(versionId);
		if(appVersion == null)
			return AjaxList.createError("您选择的记录不存在", null);
		appVersionService.doDelete(versionId);
		return AjaxList.createSuccess("操作成功", null);
	}

}