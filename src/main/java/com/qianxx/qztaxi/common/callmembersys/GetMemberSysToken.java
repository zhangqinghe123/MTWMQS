package com.qianxx.qztaxi.common.callmembersys;

import com.qianxx.qztaxi.common.callmembersys.message.LoginInfoMessageResult;
import com.qianxx.qztaxi.common.callmembersys.message.MessageResult;
import com.qianxx.qztaxi.common.callmembersys.message.TokenStore;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * 获取会员系统分配的Token
 * <p>Title: GetMemberSysToken</p>
 * <p>Description: </p>
 * <p>Company: anjie</p>
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * @author zhangqinghe
 * @version 1.0.0
 * @date 2018年2月7日 下午5:19:16
 */
public class GetMemberSysToken {

    private static final GetMemberSysToken instance = new GetMemberSysToken();

    private static final TokenStore TOKEN_STORE = new TokenStore();

    private GetMemberSysToken() {
    }

    public static GetMemberSysToken getInstance() {
        return instance;
    }

    /**
     * 单线程获取token值
     *
     * @param forceRefresh 强制刷新，在认证失败的情况下，强制刷新
     * @return
     */
    public synchronized String getToken(boolean forceRefresh) {
        String transactionId = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS") + RandomStringUtils.randomNumeric(4);
        if (!forceRefresh && StringUtils.isNotBlank(TOKEN_STORE.getAccessToken()) && new Date().getTime() < TOKEN_STORE.getExpireDate()) {
            ApiLoggerFactory.log().info(this.getClass(), "getToken", transactionId, "Get token from cache, token=" + TOKEN_STORE.toString());
            return TOKEN_STORE.getAccessToken();
        }
        // 从会员系统重新获取token
        ApiLoggerFactory.log().info(this.getClass(), "getToken", transactionId, "Get token from server, token=" + TOKEN_STORE.toString());
        CallMemberSysService service = new CallMemberSysService();
        LoginInfoMessageResult result = service.getToken(transactionId);
        if ("200".equals(result.getCode()) && null != result.getData() && null != result.getData() && null != result.getData().getExpireTime()) {
            // 超期时间减去3秒，防止网络上有消耗
            TOKEN_STORE.setAccessToken(result.getData().getAccessToken());
            TOKEN_STORE.setExpireDate(result.getData().getExpireTime());
            return result.getData().getAccessToken();
        }
        return null;
    }

}
