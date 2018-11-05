package com.qianxx.qztaxi.common.yingyan;

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
//        CreatePolygonFenceRequest request = new CreatePolygonFenceRequest();
//        request.setFenceName("test");
//        request.setMonitoredPerson("user_9");
//        request.setVertexes("41.811957,123.439476;41.812011,123.441776;41.808919,123.441776;41.808812,123.439692");
//        String result = FenceHandler.createPolygonFence(request);
//        System.out.println(result);

        DeleteFenceRequest deleteFenceRequest = new DeleteFenceRequest();
        deleteFenceRequest.setMonitored_person("user_9");
        String deleteFenceResult = FenceHandler.deleteFenceByMonitorPerson(deleteFenceRequest);
        System.out.println(deleteFenceResult);

        ListFenceRequest request = new ListFenceRequest();
        request.setMonitored_person("user_9");
        String result = FenceHandler.listFenceByMonitorPerson(request);
        System.out.println(result);
    }
}
