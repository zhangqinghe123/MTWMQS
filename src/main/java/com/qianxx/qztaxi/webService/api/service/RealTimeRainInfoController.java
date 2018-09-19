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
@RequestMapping(value = "api/realTimeRainInfo")
@Api(value = "【业务】查询实时汛情-雨情")
public class RealTimeRainInfoController {
    @Autowired
    private StPptnRService stPptnRService;

    @RequestMapping(value = "getRealTimeRainInfoByTime", method = RequestMethod.GET)
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "统计起始时间", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "endTime", value = "统计终止时间", dataType = "Long", paramType = "query", required = true)})
    @ApiOperation(value = "根据时间查询雨情信息", notes = "根据时间查询雨情信息", httpMethod = "GET")
    public AjaxList getRealTimeRainInfoByTime(@RequestParam Long startTime, @RequestParam Long endTime) {
        try {
            return AjaxList.createSuccess("成功", stPptnRService.getRealTimeRainInfoByTime(startTime, endTime));
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }
    }
}
