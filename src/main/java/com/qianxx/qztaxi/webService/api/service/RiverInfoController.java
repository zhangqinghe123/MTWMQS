package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.service.StPptnRService;
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
@RequestMapping(value = "api/riverInfo")
@Api(value = "【业务】查询河流水位信息")
public class RiverInfoController {

    @Autowired
    private StRiverRService stRiverRService;

    @RequestMapping(value = "getNewestRiverInfo", method = RequestMethod.GET)
    @ApiImplicitParams({@ApiImplicitParam(name = "stcds", value = "河流站的stcd，多个使用英文逗号分隔，不携带默认返回全部", dataType = "String", paramType = "query")})
    @ApiOperation(value = "获取河流站最新水位信息(上报数据里面最新的)", notes = "获取河流站最新水位信息", httpMethod = "GET")
    public AjaxList getNewestRiverInfo(@RequestParam(required = false) String stcds) {
        try {
            return AjaxList.createSuccess("成功", stRiverRService.getNewestRiverInfo(stcds));
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }

    @RequestMapping(value = "getRiverInfoByTime", method = RequestMethod.GET)
    @ApiImplicitParams({ @ApiImplicitParam(name = "startTime", value = "统计起始时间(yyyy-MM-dd HH)", dataType = "String", paramType = "query", required = true) ,
            @ApiImplicitParam(name = "endTime", value = "统计终止时间(yyyy-MM-dd HH)", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "stcd", value = "河流站的stcd", dataType = "String", paramType = "query", required = true)})
    @ApiOperation(value = "获取河流站水位流量信息", notes = "获取河流站水位流量信息", httpMethod = "GET")
    public AjaxList getRiverInfoByTime(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String stcd) {
        try {
            return AjaxList.createSuccess("成功", stRiverRService.getRiverInfoByTime(startTime, endTime,stcd));
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }

    }

}