package com.qianxx.qztaxi.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qianxx.qztaxi.log.factory.ManagerLoggerFactory;

public class AdminInterceptor extends HandlerInterceptorAdapter {

    // 过滤的uri
    private List<String> urls;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // api访问权限校验（http暴露在网络中，所以简单的只能针对一个加密的钥匙串来判断是否有权限，如果其他人获取了该key和token，那就可以访问）
        // 登录校验以及token，userId转换
        String callUrl = request.getRequestURI();
        ManagerLoggerFactory.getInstance().info(AdminInterceptor.class, "preHandle", "", "visit url is " + callUrl);
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            throw new NullPointerException();
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

}