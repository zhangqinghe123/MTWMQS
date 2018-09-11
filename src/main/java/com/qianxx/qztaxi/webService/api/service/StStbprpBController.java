package com.qianxx.qztaxi.webService.api.service;

import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/ststbprpb")
@Api(value = "站点信息查询接口")
public class StStbprpBController {

    @Autowired
    private StStbprpBService stStbprpBService;


    @RequestMapping(value = "getRainSiteInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取雨量站信息", notes = "获取雨量站信息", httpMethod = "GET")
    public AjaxList getRainSiteInfo() {
        return AjaxList.createSuccess("检查成功", stStbprpBService.getAllRainStations(10, 0));
    }

}