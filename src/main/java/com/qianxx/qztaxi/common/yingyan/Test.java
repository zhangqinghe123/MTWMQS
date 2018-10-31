package com.qianxx.qztaxi.common.yingyan;

import com.alibaba.fastjson.JSONObject;
import com.qianxx.qztaxi.common.yingyan.api.fence.CreatePolygonFenceRequest;

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
        JSONObject jsonRsp = JSONObject.parseObject(result);
        System.out.println(jsonRsp.getString("status"));
        System.out.println(jsonRsp.getString("message"));
        System.out.println(jsonRsp.getString("fence_id"));
    }
}
