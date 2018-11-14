package com.qianxx.qztaxi.common.callmembersys;

import com.alibaba.fastjson.JSONObject;
import com.qianxx.qztaxi.common.callmembersys.message.MessageResult;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>Title: AbstractCallLeaguerSys</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p>
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * @author Administrator
 * @version 1.0.0
 * @date 2018年1月30日 上午11:03:30
 */
public abstract class AbstractCallMemberSys {

    /**
     * 向会员系统发送消息Get消息
     *
     * @param url          请求地址
     * @param params       参数Map
     * @param responseType 响应类型
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T get(String transactionId, String url, Map<String, String> params, Class<T> responseType) throws IOException, InstantiationException, IllegalAccessException {
        return sendMessage(transactionId, initParams(url, params), HttpMethod.GET, responseType, null);
    }

    /**
     * 向会员系统发送消息Post消息
     *
     * @param url          请求地址
     * @param params       参数Map
     * @param responseType 响应类型
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T post(String transactionId, String url, Map<String, String> params, Class<T> responseType, JSONObject param)
            throws IOException, InstantiationException, IllegalAccessException {
        return sendMessage(transactionId, initParams(url, params), HttpMethod.POST, responseType, param);
    }

    /**
     * 通过Get方式向会员系统发送消息
     *
     * @param url          请求地址
     * @param httpMethod   请求方式
     * @param responseType 响应的类型
     * @return 根据参数传入参数
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private <T> T sendMessage(String transactionId, String url, HttpMethod httpMethod, Class<T> responseType, JSONObject param) throws InstantiationException, IllegalAccessException {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<JSONObject> formEntity = new HttpEntity<JSONObject>(param, headers);
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(30000).build();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config);
        HttpClient httpClient = builder.build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<T> result = restTemplate.exchange(url, httpMethod, formEntity, responseType);
        return result.getBody();
    }

    /**
     * 初始化URL
     *
     * @param url
     * @param params
     * @return
     */
    private String initParams(String url, Map<String, String> params) {
        if (null == params || params.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        if (url.indexOf("?") == -1) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        boolean first = true;
        for (Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append("=");
            if (!StringUtils.isEmpty(value)) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

}
