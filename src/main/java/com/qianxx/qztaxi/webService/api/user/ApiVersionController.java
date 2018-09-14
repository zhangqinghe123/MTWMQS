package com.qianxx.qztaxi.webService.api.user;

import com.qianxx.qztaxi.common.util.FileUtils;
import com.qianxx.qztaxi.po.AppVersion;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:33
 */
@RestController
@RequestMapping(value = "api/version")
@Api(value = "版本更新")
public class ApiVersionController {

    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping(value = "getNewestVersion", method = RequestMethod.GET)
    @ApiOperation(value = "获得最新版本", notes = "用户登录", httpMethod = "GET")
    public AjaxList getNewestVersion(@RequestParam() int verionCode) {
        List<AppVersion> newVersion = appVersionService.getNewestVersion(verionCode);
        if (!CollectionUtils.isEmpty(newVersion)) {
            return AjaxList.createSuccess("获得最新版本", newVersion.get(0));
        }
        return AjaxList.createSuccess("获得最新版本", null);
    }

    @RequestMapping(value = "downloadApp", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "现在最新版本", notes = "现在最新版本", httpMethod = "GET")
    public AjaxList downloadApp(HttpServletResponse response) {
        List<AppVersion> appVersions = appVersionService.getNewestVersion(0);
        if (appVersions == null) {
            return AjaxList.createError("无版本信息", null);
        }
        AppVersion appVersion = appVersions.get(0);
        try {
            FileUtils.downloadApp(appVersion.getDownLoadUrl(), response, "mtwmqs_" + appVersion.getVersionCode());
        } catch (Exception e) {
            return AjaxList.createError("下载失败:" + e.getMessage(), null);
        }
        return AjaxList.createSuccess("操作成功", null);
    }
}
