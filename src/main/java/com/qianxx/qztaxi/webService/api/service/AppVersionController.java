package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.service.AppVersionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/version")
@Api(value = "APP管理接口")
public class AppVersionController {

	@Autowired
	private AppVersionService appVersionService;
//
//	@RequestMapping(value = "getNewVersion", method = RequestMethod.GET)
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "versionCode", value = "版本号", dataType = "string", paramType = "query", required = true),
//		@ApiImplicitParam(name = "terminal", value = "终端类型1用户端，2司机端", dataType = "int", paramType = "query", required = true)})
//	@ApiOperation(value = "获取最新版本(司机,乘客端使用)", notes = "获取最新版本(司机,乘客端使用)", httpMethod = "GET")
//	public AjaxList getNewVersion(
//			@RequestParam(value = "versionCode", required = true) String versionCode,
//			@RequestParam(value = "terminal", required = true) Integer terminal) {
//		if (terminal == null || (terminal != 1 && terminal != 2))
//			return AjaxList.createError("参数错误", null);
//		AppVersionResult appVersionResult = new AppVersionResult();
//		appVersionResult.setIsNew(0);
//		AppVersion appVersion = new AppVersion();
//		if (StringUtils.isBlank(versionCode)) {
//			appVersion = appVersionService.getNewVersion(null, terminal);
//			if (appVersion != null) {
//				BeanUtils.copyProperties(appVersion, appVersionResult);
//				appVersionResult.setIsNew(1);
//			}
//			return AjaxList.createSuccess("检查成功", appVersionResult);
//		} else {
//			appVersion = appVersionService.getByCode(versionCode, terminal);
//			if (appVersion == null) {
//				appVersion = appVersionService.getNewVersion(null, terminal);
//				if (appVersion != null) {
//					BeanUtils.copyProperties(appVersion, appVersionResult);
//					appVersionResult.setIsNew(1);
//				}
//				return AjaxList.createSuccess("检查成功", appVersionResult);
//			}
//		}
//		appVersion = appVersionService.getNewVersion(appVersion.getVersionId(), terminal);
//		if (appVersion != null) {
//			BeanUtils.copyProperties(appVersion, appVersionResult);
//			appVersionResult.setIsNew(1);
//		}
//		return AjaxList.createSuccess("检查成功", appVersionResult);
//	}

}