package com.qianxx.qztaxi.common.yingyan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.qianxx.qztaxi.common.yingyan.api.fence.CreatePolygonFenceRequest;
import com.qianxx.qztaxi.common.yingyan.api.fence.DeleteFenceRequest;
import com.qianxx.qztaxi.common.yingyan.api.fence.ListFenceRequest;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/10/31 14:54
 */
public class Test {
    public static void main(String[] args) {
        CreatePolygonFenceRequest request = new CreatePolygonFenceRequest();
        request.setFenceName("test");
        request.setMonitoredPerson("user_9");
        request.setVertexes("41.811957,123.439476;41.812011,123.441776;41.808919,123.441776;41.808812,123.439692");
        String result = FenceHandler.createPolygonFence(request);
        System.out.println(result);

//        DeleteFenceRequest deleteFenceRequest = new DeleteFenceRequest();
//        deleteFenceRequest.setMonitored_person("user_9");
//        String deleteFenceResult = FenceHandler.deleteFenceByMonitorPerson(deleteFenceRequest);
//        System.out.println(deleteFenceResult);
//
//        ListFenceRequest request = new ListFenceRequest();
//        request.setMonitored_person("user_9");
//        String result = FenceHandler.listFenceByMonitorPerson(request);
//        System.out.println(result);
//        JSONObject resultJson = JSONObject.parseObject(result);
//        if ("0".equals(resultJson.getString("status")) && resultJson.getInteger("size") > 0) {
//            JSONArray locationArray = resultJson.getJSONArray("fences").getJSONObject(0).getJSONArray("vertexes");
//            StringBuilder builder = new StringBuilder();
//            if (locationArray.size() > 0) {
//                for (int i = 0; i < locationArray.size(); i++) {
//                    builder.append(locationArray.getJSONObject(i).getString("latitude")).append(",");
//                    builder.append(locationArray.getJSONObject(i).getString("longitude")).append(";");
//                }
//            }
//            if (builder.length() > 0 && builder.indexOf(";") > 0) {
//                builder.deleteCharAt(builder.lastIndexOf(";"));
//            }
//            System.out.println(builder.toString());
//        }
    }
}
