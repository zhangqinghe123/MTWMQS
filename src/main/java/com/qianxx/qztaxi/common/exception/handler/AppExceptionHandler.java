package com.qianxx.qztaxi.common.exception.handler;

import javax.servlet.http.HttpServletRequest;

import com.qianxx.qztaxi.common.exception.RestServiceExceptionHandler;
import com.qianxx.qztaxi.common.util.Sysutils;

public class AppExceptionHandler extends RestServiceExceptionHandler {

	@Override
	public boolean isRestServiceException(HttpServletRequest request) {
		if (request.getServletPath().startsWith(Sysutils.getWebServerindex()))
			return true;
		else
			return false;
	}
}
