package com.qianxx.qztaxi.common.yingyan;

import com.qianxx.qztaxi.common.yingyan.api.entity.*;
import com.qianxx.qztaxi.common.yingyan.api.track.IllegalTrackArgumentException;
import com.qianxx.qztaxi.common.yingyan.core.HttpClient;
import com.qianxx.qztaxi.common.yingyan.core.UrlDomain;
import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.util.CommonUtils;
import com.qianxx.qztaxi.common.yingyan.util.HttpUtils;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;

import java.util.Map;

/**
 * <p>Description: 鹰眼实体控制类</p>
 *
 * @auther: 张庆贺
 * @date: 2018/6/12 16:52
 */
public class EntityHandler {

    /**
     * 增加实体
     *
     * @param request 请求
     * @return 响应
     */
    static String addEntity(AddEntityRequest request, String transactionId) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        ApiLoggerFactory.log().info(EntityHandler.class, "addEntity", transactionId, "增加实体请求参数是" + parameters.toString());
        return HttpClient.sendRequest(UrlDomain.ACTION_ADD_ENTITY, parameters.toString(), HttpClient.METHOD_POST);
    }

    public static String deleteEntity(DeleteEntityRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_DELETE_ENTITY, parameters.toString(), HttpClient.METHOD_POST);
    }

    static String updateEntity(UpdateEntityRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_UPDATE_ENTITY, parameters.toString(), HttpClient.METHOD_POST);
    }


    public static String aroundSearchEntity(AroundSearchEntityRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_AROUND_SEARCH, parameters.toString(), HttpClient.METHOD_GET);
    }

    public static String listEntity(ListEntityRequest request) {
        StringBuilder parameters = new StringBuilder();
        packRequest(request, parameters);
        return HttpClient.sendRequest(UrlDomain.ACTION_ENTITY_LIST, parameters.toString(), HttpClient.METHOD_GET);
    }

    /**
     * 组装请求
     */
    private static void packRequest(BaseRequest request, StringBuilder parameters) {
        if (null == request) {
            throw new IllegalTrackArgumentException("request can not be null.");
        }
        CommonUtils.packCommonRequest(parameters);
        if (request instanceof AddEntityRequest) {
            AddEntityRequest addEntityRequest = (AddEntityRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(addEntityRequest.getEntityName()));
            Map<String, String> columnMap = addEntityRequest.getColumnMap();
            for (String key : columnMap.keySet()) {
                parameters.append("&").append(key).append("=").append(HttpUtils.urlEncode(columnMap.get(key)));
            }
        } else if (request instanceof UpdateEntityRequest) {
            UpdateEntityRequest updateEntityRequest = (UpdateEntityRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(updateEntityRequest.getEntityName()));
            Map<String, String> columnMap = updateEntityRequest.getColumnMap();
            for (String key : columnMap.keySet()) {
                parameters.append("&").append(key).append("=").append(HttpUtils.urlEncode(columnMap.get(key)));
            }
        } else if (request instanceof AroundSearchEntityRequest) {
            AroundSearchEntityRequest aroundSearchEntityRequest = (AroundSearchEntityRequest) request;
            parameters.append("&center=").append(HttpUtils.urlEncode(aroundSearchEntityRequest.getCenter()));
            parameters.append("&radius=").append(HttpUtils.urlEncode(String.valueOf(aroundSearchEntityRequest.getRadius())));
            parameters.append("&filter=").append(HttpUtils.urlEncode(aroundSearchEntityRequest.getFilter()));
            parameters.append("&coord_type_input=").append(HttpUtils.urlEncode(String.valueOf(aroundSearchEntityRequest.getCoordTypeInput())));
            parameters.append("&coord_type_output=").append(HttpUtils.urlEncode(String.valueOf(aroundSearchEntityRequest.getCoordTypeOutput())));
            parameters.append("&page_index=").append(HttpUtils.urlEncode(String.valueOf(aroundSearchEntityRequest.getPageIndex())));
            parameters.append("&page_size=").append(HttpUtils.urlEncode(String.valueOf(aroundSearchEntityRequest.getPageSize())));
        } else if (request instanceof DeleteEntityRequest) {
            DeleteEntityRequest entityRequest = (DeleteEntityRequest) request;
            parameters.append("&entity_name=").append(HttpUtils.urlEncode(entityRequest.getEntityName()));
        } else if (request instanceof ListEntityRequest) {
            ListEntityRequest listRequest = (ListEntityRequest) request;
            parameters.append("&filter=").append(HttpUtils.urlEncode(listRequest.getFilter()));
            parameters.append("&coord_type_output=").append(HttpUtils.urlEncode(String.valueOf(listRequest.getCoordTypeOutput())));
            parameters.append("&page_index=").append(HttpUtils.urlEncode(String.valueOf(listRequest.getPageIndex())));
            parameters.append("&page_size=").append(HttpUtils.urlEncode(String.valueOf(listRequest.getPageSize())));
        }
    }
}
