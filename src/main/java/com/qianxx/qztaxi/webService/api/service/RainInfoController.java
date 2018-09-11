package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.service.StPptnRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/rainInfo")
@Api(value = "查询雨量信息")
public class RainInfoController {

    @Autowired
    private StPptnRService stPptnRService;


    @RequestMapping(value = "getRainInfoByTime", method = RequestMethod.GET)
    @ApiOperation(value = "获取雨量站信息", notes = "获取雨量站信息", httpMethod = "GET")
    public AjaxList getRainInfoByTime(@RequestParam Integer pageSize, @RequestParam Integer pageNum, @RequestParam String startTime, @RequestParam String endTime) {
        try {
            return AjaxList.createSuccess("检查成功", stPptnRService.getAllRainStations(pageSize, pageNum, startTime, endTime));
        } catch (RestServiceException e) {
            return AjaxList.createJsonDate(e.getStatus(), e.getErrorCode(), e.getMessage(), null);
        }

    }

}