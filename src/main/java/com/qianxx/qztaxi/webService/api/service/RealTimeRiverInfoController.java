package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.service.StRiverRService;
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
@RequestMapping(value = "api/realTimeRiverInfo")
@Api(value = "【业务】查询实时汛情-河道水情")
public class RealTimeRiverInfoController {

    @Autowired
    private StRiverRService stRiverRService;

    @RequestMapping(value = "getRiverInfoList", method = RequestMethod.GET)
    @ApiOperation(value = "获取河流站最新水位信息", notes = "获取河流站最新水位信息", httpMethod = "GET")
    public AjaxList getRiverInfoList() {
        try {
            return AjaxList.createSuccess("成功", stRiverRService.getRiverInfoList());
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }
}