package com.qianxx.qztaxi.webService.api.service;

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
@RequestMapping(value = "api/ststbprpb")
@Api(value = "【业务】站点信息查询接口")
public class StStbprpBController {

    @Autowired
    private StStbprpBService stStbprpBService;

    @RequestMapping(value = "getRainSiteInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取雨量站信息【有雨量信息上传】", notes = "获取雨量站信息", httpMethod = "GET")
    public AjaxList getRainSiteInfo() {
        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllRainStations());
    }

    @RequestMapping(value = "getAllReservoirStations", method = RequestMethod.GET)
    @ApiOperation(value = "获取水库站信息【有水库水位上传的】", notes = "获取水库站信息", httpMethod = "GET")
    public AjaxList getAllReservoirStations() {
        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllReservoirStations());
    }

    @RequestMapping(value = "getAllRiverStations", method = RequestMethod.GET)
    @ApiOperation(value = "获取河流站信息【有河流水位信息上传的】", notes = "获取河流站信息", httpMethod = "GET")
    public AjaxList getAllRiverStations() {
        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllRiverStations());
    }
//
//    @RequestMapping(value = "getAllHydrologyStations", method = RequestMethod.GET)
//    @ApiOperation(value = "获取水文站信息【ACTUNIT区分】", notes = "获取水文站信息", httpMethod = "GET")
//    public AjaxList getAllHydrologyStations() {
//        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllHydrologyStations());
//    }
//
//    @RequestMapping(value = "getAllMountainTorrentStations", method = RequestMethod.GET)
//    @ApiOperation(value = "获取山洪站信息【ACTUNIT区分】", notes = "获取山洪站信息", httpMethod = "GET")
//    public AjaxList getAllMountainTorrentStations() {
//        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllMountainTorrentStations());
//    }


    @RequestMapping(value = "getAllStations", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有站点信息", notes = "获取山洪站信息", httpMethod = "GET")
    public AjaxList getAllStations() {
        return AjaxList.createSuccess("查询成功", stStbprpBService.getAllStations());
    }

    @RequestMapping(value = "getStationInfoByStcd", method = RequestMethod.GET)
    @ApiOperation(value = "获取站点详细信息", notes = "获取站点详细信息", httpMethod = "GET")
    public AjaxList getStationInfoByStcd(@RequestParam String stcd) {
        return AjaxList.createSuccess("查询成功", stStbprpBService.getStationInfoByStcd(stcd));
    }

}