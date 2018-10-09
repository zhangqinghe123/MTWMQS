package com.qianxx.qztaxi.common.yingyan;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonIOException;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.common.yingyan.api.track.*;
import com.qianxx.qztaxi.common.yingyan.core.HttpClient;
import com.qianxx.qztaxi.common.yingyan.core.UrlDomain;
import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.TrackPoint;
import com.qianxx.qztaxi.common.yingyan.model.YingYanConstants;
import com.qianxx.qztaxi.common.yingyan.util.CommonUtils;
import com.qianxx.qztaxi.common.yingyan.util.HttpUtils;
import com.qianxx.qztaxi.common.yingyan.util.TrackUtils;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 轨迹处理器
 * <p>Title: TrackHandler</p>
 * <p>Description: </p>
 * <p>Company: anjie</p>
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * @author zhangqinghe
 * @version 1.0.0
 * @date 2018年5月7日 下午4:36:22
 */
public class TrackHandler {

    /**
     * 添加单个轨迹点
     *
     * @param request
     */
    public static String addPoint(AddPointRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_ADD_POINT, parameters.toString(), HttpClient.METHOD_POST);
    }

    /**
     * 批量添加轨迹点
     *
     * @param request
     */
    public static String addPoints(AddPointsRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_ADD_POINTS, parameters.toString(), HttpClient.METHOD_POST);
    }

    public static double reqDistance(GetdistanceRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);

        String rspString = HttpClient.sendRequest(UrlDomain.ACTION_GET_DISTANCE, parameters.toString(), HttpClient.METHOD_GET);
        JSONObject rspJson = JSONObject.parseObject(rspString);
        if (rspJson != null && rspJson.getString("status").equals("0") && !StringUtils.isEmpty(rspJson.getString("distance"))) {
            return rspJson.getDoubleValue("distance");
        } else {
            ApiLoggerFactory.log().error(TrackHandler.class, "reqDistance", "", rspString);
            throw new RestServiceException("鹰眼服务异常");
        }
    }

    public static double getdistance(GetdistanceRequest request) {
        double distance = 0;
        long startUnixTime = request.getStartTime();
        long endUnixTime = request.getEndTime();
        // 超过5个小时，按照5小时分片处理

        // 如果起始时长超过5分钟，分段计算停止时间
        long interval = endUnixTime - startUnixTime;
        if (interval > YingYanConstants.FRAGMENT_FIVE_HOURS) {
            for (int i = 0; i <= interval / YingYanConstants.FRAGMENT_FIVE_HOURS; i++) {
                long tmpStart = startUnixTime + i * YingYanConstants.FRAGMENT_FIVE_HOURS;
                long tmpEnd = startUnixTime + (i + 1) * YingYanConstants.FRAGMENT_FIVE_HOURS;
                if (tmpEnd > endUnixTime) {
                    tmpEnd = endUnixTime;
                }
                request.setStartTime(tmpStart);
                request.setEndTime(tmpEnd);
                distance += reqDistance(request);
            }
        } else {
            distance += reqDistance(request);
        }
        return new BigDecimal(distance).divide(new BigDecimal("1000"), 1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 获取实体一段时间内轨迹
     *
     * @param request
     * @return
     */
    public static List<Map<String, String>> getTrack(GetTrackRequest request) {
        List<Map<String, String>> resultMap = new ArrayList<>();
        boolean isContinue = true;
        int pageIndex = 1;
        request.setPageIndex(pageIndex);
        while (isContinue) {
            String rspString = getTrackReq(request);
            JSONObject jsonRsp = JSONObject.parseObject(rspString);
            if (jsonRsp == null){
                continue;
            }
            if (!"0".equals(jsonRsp.getString("status"))) {
                throw new RestServiceException(jsonRsp.getString("message"), ErrCodeConstants.ERR_1000_PARAMS_ERR, "0");
            }
            if (jsonRsp.getInteger("total") <= 0){
                continue;
            }
            int size = jsonRsp.getInteger("size");
            for (Object t : jsonRsp.getJSONArray("points")) {
                Map<String, String> map = new HashMap<String, String>();
                JSONObject tmp = JSONObject.parseObject(t.toString());
                map.put("lng", tmp.getString("longitude"));
                map.put("lat", tmp.getString("latitude"));
                resultMap.add(map);

            }
            if (size < YingYanConstants.DEFAULT_PAGE_SIZE_MANAGER) {
                isContinue = false;
            }
            pageIndex++;
        }
        return resultMap;
    }

    private static String getTrackReq(GetTrackRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_GET_TRACK, parameters.toString(), HttpClient.METHOD_GET);
    }

    /**
     * 组装请求
     *
     * @return
     */
    private static void packRequest(BaseRequest request, StringBuilder parameters) {
        if (null == request) {
            throw new IllegalTrackArgumentException("request can not be null.");
        }

        CommonUtils.packCommonRequest(parameters);

        if (request instanceof AddPointRequest) {
            AddPointRequest addPointRequest = (AddPointRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(addPointRequest.getEntityName()));
            TrackPoint trackPoint = addPointRequest.getTrackPoint();
            if (null == trackPoint) {
                throw new IllegalTrackArgumentException("trackPoint can not be null.");
            }
            TrackUtils.packPoint(trackPoint, parameters);
        } else if (request instanceof GetdistanceRequest) {
            GetdistanceRequest getdistanceRequest = (GetdistanceRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(getdistanceRequest.getEntityName()));
            parameters.append("&start_time=").append(getdistanceRequest.getStartTime());
            parameters.append("&end_time=").append(getdistanceRequest.getEndTime());
            parameters.append("&is_processed=").append(getdistanceRequest.getIsProcessed());
            parameters.append("&process_option=").append(getdistanceRequest.getTrackParam().getUrlParam());
            parameters.append("&supplement_mode=").append(getdistanceRequest.getSupplementMode());
        } else if (request instanceof GetTrackRequest) {
            GetTrackRequest getTrackRequest = (GetTrackRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(getTrackRequest.getEntityName()));
            parameters.append("&start_time=").append(getTrackRequest.getStartTime());
            parameters.append("&end_time=").append(getTrackRequest.getEndTime());
            parameters.append("&is_processed=").append(getTrackRequest.getIsProcessed());
            parameters.append("&process_option=").append(getTrackRequest.getTrackParam().getUrlParam());
//            parameters.append("&supplement_mode=").append(getTrackRequest.getSupplementMode());
            parameters.append("&page_index=").append(getTrackRequest.getPageIndex());
            parameters.append("&page_size=").append(getTrackRequest.getPageSize());
        } else {
            AddPointsRequest addPointsRequest = (AddPointsRequest) request;
            TrackUtils.packPoints(addPointsRequest.getTrackPoints(), parameters);
        }
    }
}
