package com.qianxx.qztaxi.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 授权校验，token校验，token转换<br>
 * 由于http访问容易被抓包，所以增加一个api授权key来拦截所有api的访问
 * 但是这并不是最安全的，只能避免不抓包的情况下的安全访问
 * 如果要加深安全性，可以在客户端对所有参数进行加密，或者增加一个oAuth授权平台，再或者改用https协议
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {

//	private final String API_ENCRYPT_KEY = "04d05bb368347f88";
	// 只是为了不明文去判断是否符合规范
//	private final String API_KEY_MD5_KEY = "57706C9598B695A986FE6E2926B4DA9A";
	// 过滤的uri
	private List<String> uris;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// api访问权限校验（http暴露在网络中，所以简单的只能针对一个加密的钥匙串来判断是否有权限，如果其他人获取了该key和token，那就可以访问）
		// 登录校验以及token，userId转换
//		String callUrl = request.getRequestURI();
//		callUrl = callUrl.replaceFirst(request.getContextPath(), "");
//		Date date = new Date();
//		request.setAttribute("callUrl", date.getTime());
//		request.setAttribute("key", callUrl);
//		if (!uris.contains(callUrl)) {
//			String token = request.getHeader("token");
//			if (!StringUtil.isNotBlank(token))
//				throw new RestServiceException("未获取到用户,请先登录", ErrCodeConstants.ERR_410_FAIL_KEY, "1");
//			else {
//				Usertoken usertoken = usertokenService.getUserIdByToken(token);
//				if (null == usertoken)
//					throw new RestServiceException("抱歉您的账号已经在其他设备上登录", ErrCodeConstants.ERR_2000_TOKEN_ERR, "0");
//				else {
//					// 这里不需要判断用户ID为空，因为业务中用户ID是不会清空的，如果是空的，说明其他业务出现了错误
//					Integer userId = usertoken.getUserId();
//					request.setAttribute("userId", userId);
//				}
//			}
//		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	public List<String> getUris() {
		return uris;
	}

	public void setUris(List<String> uris) {
		this.uris = uris;
	}

}