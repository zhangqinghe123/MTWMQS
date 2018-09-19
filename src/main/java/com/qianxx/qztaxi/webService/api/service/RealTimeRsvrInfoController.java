package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.service.StRsvrRService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/riverInfo")
@Api(value = "【业务】查询实时汛情-水库水情")
public class RealTimeRsvrInfoController {

    @Autowired
    private StRsvrRService stRsvrRService;

    @RequestMapping(value = "getRsvrInfoList", method = RequestMethod.GET)
    @ApiOperation(value = "获取水库站最新水情信息", notes = "获取水库站最新水情信息", httpMethod = "GET")
    public AjaxList getRsvrInfoList() {
        try {
            return AjaxList.createSuccess("成功", stRsvrRService.getRsvrInfoList());
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }

}