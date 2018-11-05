package com.qianxx.qztaxi.common.yingyan;

import com.mchange.v2.sql.filter.RecreatePackage;
import com.qianxx.qztaxi.common.yingyan.api.fence.CreatePolygonFenceRequest;
import com.qianxx.qztaxi.common.yingyan.api.fence.ListFenceRequest;
import com.qianxx.qztaxi.common.yingyan.api.track.*;
import com.qianxx.qztaxi.common.yingyan.core.HttpClient;
import com.qianxx.qztaxi.common.yingyan.core.UrlDomain;
import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.TrackPoint;
import com.qianxx.qztaxi.common.yingyan.util.CommonUtils;
import com.qianxx.qztaxi.common.yingyan.util.HttpUtils;
import com.qianxx.qztaxi.common.yingyan.util.TrackUtils;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/10/31 14:22
 */
public class FenceHandler {

    public static String createPolygonFence(CreatePolygonFenceRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.FENCE_CREATE_POLYGON_FENCE, parameters.toString(), HttpClient.METHOD_POST);
    }

    public static String listFence(ListFenceRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.FENCE_LIST_FENCE, parameters.toString(), HttpClient.METHOD_GET);
    }


    private static void packRequest(BaseRequest request, StringBuilder parameters) {
        if (null == request) {
            throw new IllegalTrackArgumentException("request can not be null.");
        }
        CommonUtils.packCommonRequest(parameters);
        if (request instanceof CreatePolygonFenceRequest) {
            CreatePolygonFenceRequest createPolygonFenceRequest = (CreatePolygonFenceRequest) request;
            parameters.append("&fence_name=").append(HttpUtils.urlEncode(createPolygonFenceRequest.getFenceName()));
            parameters.append("&monitored_person=").append(HttpUtils.urlEncode(createPolygonFenceRequest.getMonitoredPerson()));
            parameters.append("&vertexes=").append(HttpUtils.urlEncode(createPolygonFenceRequest.getVertexes()));
            parameters.append("&coord_type=").append(HttpUtils.urlEncode(createPolygonFenceRequest.getCoordType()));
            parameters.append("&denoise=").append(HttpUtils.urlEncode(String.valueOf(createPolygonFenceRequest.getDenoise())));
        } else if (request instanceof ListFenceRequest) {
            ListFenceRequest listFenceRequest = (ListFenceRequest) request;
            parameters.append("&monitored_person=").append(HttpUtils.urlEncode(listFenceRequest.getMonitored_person()));
        } else {
            AddPointsRequest addPointsRequest = (AddPointsRequest) request;
            TrackUtils.packPoints(addPointsRequest.getTrackPoints(), parameters);
        }
    }
}
