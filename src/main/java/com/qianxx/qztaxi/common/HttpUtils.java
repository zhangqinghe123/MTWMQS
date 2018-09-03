package com.qianxx.qztaxi.common;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	/**
	 * HTTP的GET请求
	 */
	public static HttpModel httpGet(String url) throws Exception {
		return httpGet(url, null);
	}

	/**
	 * HTTP的GET请求
	 */
	public static HttpModel httpGet(String url, Map<String, String> headMap) throws Exception {
		HttpModel httpModel = new HttpModel();
		String responseContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		setGetHead(httpGet, headMap);
		try {
			HttpEntity entity = response.getEntity();
			responseContent = getRespString(entity);
			EntityUtils.consume(entity);
		} finally {
			response.close();
			httpclient.close();
		}
		httpModel.setCode(response.getStatusLine().getStatusCode());
		httpModel.setResult(responseContent);
		return httpModel;
	}

	/**
	 * HTTP的POST请求
	 */
	public static HttpModel httpPost(String url, Map<String, String> paramsMap) throws Exception {
		return httpPost(url, paramsMap, null);
	}

	/**
	 * HTTP的POST请求
	 */
	public static HttpModel httpPost(String url, Map<String, String> paramsMap, Map<String, String> headMap) throws Exception {
		HttpModel httpModel = new HttpModel();
		String responseContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		setPostHead(httpPost, headMap);
		setPostParams(httpPost, paramsMap);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
			HttpEntity entity = response.getEntity();
			responseContent = getRespString(entity);
			EntityUtils.consume(entity);
		} finally {
			response.close();
			httpclient.close();
		}
		httpModel.setCode(response.getStatusLine().getStatusCode());
		httpModel.setResult(responseContent);
		return httpModel;
	}

	/**
	 * 设置POST的参数
	 */
	private static void setPostParams(HttpPost httpPost, Map<String, String> paramsMap) throws Exception {
		if (paramsMap != null && paramsMap.size() > 0) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			Set<String> keySet = paramsMap.keySet();
			for (String key : keySet)
				nvps.add(new BasicNameValuePair(key, paramsMap.get(key)));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		}
	}

	/**
	 * 设置http的HEAD
	 */
	private static void setPostHead(HttpPost httpPost, Map<String, String> headMap) {
		if (headMap != null && headMap.size() > 0) {
			Set<String> keySet = headMap.keySet();
			for (String key : keySet)
				httpPost.addHeader(key, headMap.get(key));
		}
	}

	/**
	 * 设置http的HEAD
	 */
	private static void setGetHead(HttpGet httpGet, Map<String, String> headMap) {
		if (headMap != null && headMap.size() > 0) {
			Set<String> keySet = headMap.keySet();
			for (String key : keySet)
				httpGet.addHeader(key, headMap.get(key));
		}
	}

	/**
	 * 将返回结果转化为String
	 */
	private static String getRespString(HttpEntity entity) throws Exception {
		if (entity == null)
			return null;
		InputStream is = entity.getContent();
		StringBuffer strBuf = new StringBuffer();
		byte[] buffer = new byte[4096];
		int r = 0;
		while ((r = is.read(buffer)) > 0)
			strBuf.append(new String(buffer, 0, r, "UTF-8"));
		return strBuf.toString();
	}

}