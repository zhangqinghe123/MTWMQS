package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.service.StPptnRService;
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
@RequestMapping(value = "api/rainFallInfo")
@Api(value = "【业务】查询降雨量信息")
public class RainInfoController {

    @Autowired
    private StPptnRService stPptnRService;

    @RequestMapping(value = "getRainfallInfoByTime", method = RequestMethod.GET)
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "统计起始时间", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "endTime", value = "统计终止时间", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "interval", value = "统计时间间隔（单位小时）", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "stcds", value = "雨量站的stcd，多个使用英文逗号分隔", dataType = "String", paramType = "query", required = true)})
    @ApiOperation(value = "获取雨量站监控降雨信息", notes = "获取雨量站监控降雨信息", httpMethod = "GET")
    public AjaxList getRainfallInfoByTime(@RequestParam Long startTime, @RequestParam Long endTime, @RequestParam Integer interval, @RequestParam String stcds) {
        try {
            return AjaxList.createSuccess("检查成功", stPptnRService.getRainfallInfoByTime(startTime, endTime, interval, stcds));
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }

    @RequestMapping(value = "getNewAvgRainfallInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取一个小时以内全县的平均降雨量", notes = "获取一个小时以内全县的平均降雨量", httpMethod = "GET")
    public AjaxList getNewAvgRainfallInfo() {
        try {
            return AjaxList.createSuccess("检查成功", stPptnRService.getNewAvgRainfallInfo());
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }

    @RequestMapping(value = "getRainfallGt50Num", method = RequestMethod.GET)
    @ApiOperation(value = "获取一个小时内降雨量超过50Mm的站点数量", notes = "获取一个小时内降雨量超过50Mm的站点数量", httpMethod = "GET")
    public AjaxList getRainfallGt50Num() {
        try {
            return AjaxList.createSuccess("检查成功", stPptnRService.getRainfallGt50Num());
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }

}