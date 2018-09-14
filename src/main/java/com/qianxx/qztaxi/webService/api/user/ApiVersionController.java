package com.qianxx.qztaxi.webService.api.user;

import com.qianxx.qztaxi.po.AppVersion;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
