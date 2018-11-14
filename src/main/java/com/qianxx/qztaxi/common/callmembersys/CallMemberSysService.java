package com.qianxx.qztaxi.common.callmembersys;

import com.qianxx.qztaxi.common.callmembersys.message.LoginInfoMessageResult;
import com.qianxx.qztaxi.common.callmembersys.message.MessageResult;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: CallLeaguerSys</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p>
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * @author zhangqinghe
 * @version 1.0.0
 * @date 2018年1月30日 上午11:02:40
 */
@Service
public class CallMemberSysService extends AbstractCallMemberSys {
    // 会员系统分配的APP_ID
    private static final String APP_KEY = "1eb8a2dd4def4b7db677875cbad7cb3b";
    // 会员 系统分配的APP_SECRET
    private static final String APP_SECRET = "8ead2ff8f3770cdba81fa29b12b06daf";
    // 会员系统域名
    private static final String HOST_NAME = "https://open.ys7.com/api/lapp/token/get";

    /**
     * 获取会员系统分配的token
     *
     * @param transactionId 流水号
     * @return
     */
    public LoginInfoMessageResult getToken(String transactionId) {
        final String methodName = "getToken";
        ApiLoggerFactory.log().enter(CallMemberSysService.class, methodName, transactionId);
        Map<String, String> params = new HashMap<>(1);
        params.put("appKey", APP_KEY);
        params.put("appSecret", APP_SECRET);
        LoginInfoMessageResult result = new LoginInfoMessageResult();
        try {
            result = super.post(transactionId, HOST_NAME, params, LoginInfoMessageResult.class, null);
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            result.setMsg("系统错误");
            result.setCode("500");
            ApiLoggerFactory.log().error(CallMemberSysService.class, methodName, transactionId, e.getMessage());
        }
        ApiLoggerFactory.log().exit(CallMemberSysService.class, methodName, transactionId, result.toString());
        return result;
    }
}
