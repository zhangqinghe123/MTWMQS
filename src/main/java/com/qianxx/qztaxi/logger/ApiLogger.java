package com.qianxx.qztaxi.logger;

import com.qianxx.qztaxi.common.util.StringUtil;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import com.qianxx.qztaxi.webService.response.AjaxList;
import com.qianxx.qztaxi.webService.response.WsResponse;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * WebService访问日志处理.
 */
public class ApiLogger {

	private static Logger logger = Logger.getLogger(ApiLogger.class);

	@SuppressWarnings("serial")
	private static ArrayList<String> SUPPRESS_LOG_LIST = new ArrayList<String>() {
		{
			add("com.qianxx.qztaxi.webService.api.CommonApi.updatePosition");
			add("com.qianxx.qztaxi.webService.api.CarpoolingApi.getMap");
			add("com.qianxx.qztaxi.webService.api.DriverApi.getMap");
			add("com.qianxx.qztaxi.webService.api.SpecialOrderApi.getMap");
			add("com.qianxx.qztaxi.webService.api.SpecialOrderApi.taxiMeter");
		}
	};

	/**
	 * 打印日志.
	 * @param pjp joinPoint对象
	 * @return AOP对象方法的返回值
	 */
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		// AOP对象返回值
		long startTime = System.currentTimeMillis();
		Object retObject = null;
		Object[] ob = pjp.getArgs();
		// 获取调用的类名
		String className = pjp.getTarget().getClass().toString().substring(6);
		// 获取调用的方法名
		String methodName = pjp.getSignature().getName();
		String transactionId = "";
		String rspStatus = "-1";
		ArrayList<String> list = new ArrayList<String>();
		GetParameterName gp = new GetParameterName();
		String[] parametersName = gp.getParameterNames(className, methodName);
		if (ob.length == parametersName.length) {
			for (int i = 0; i < ob.length; i++) {
				String s = parametersName[i] + " = " + StringUtil.toString(ob[i]);
				list.add(s);
				if (ob[i] instanceof HttpServletRequest) {
					transactionId = ((HttpServletRequest) ob[i]).getHeader("token");
				}
			}
		} else {
			for (int i = 0; i < ob.length; i++) {
				String s = "param" + String.valueOf(i) + " = " + StringUtil.toString(ob[i]);
				list.add(s);
				if (ob[i] instanceof HttpServletRequest) {
					transactionId = ((HttpServletRequest) ob[i]).getHeader("token");
				}
			}
		}
		StringBuffer log = new StringBuffer();
		String methodFullName = className + "." + methodName;
		try {
			retObject = pjp.proceed();
			WsResponse res = (WsResponse) retObject;
			// 方法名
			log.append("Method:" + methodFullName + "; ");
			// 参数
			log.append("Paramter:" + list.toString() + "; ");
			// 处理结果：状态
			log.append("Status:" + res.getStatus() + "; ");
			// 处理结果：错误码
			log.append("ErrCode:" + res.getErrCode() + "; ");
			// 处理结果：信息
			log.append("Message:" + res.getMessage() + "; ");
			rspStatus = res.getStatus();
			return retObject;
		} catch (Exception e) {
			logger.error("系统异常,流水号:" + transactionId + ".异常:" + e.getMessage(), e);
			log.append("Method:" + methodFullName + "; ");
			log.append("Paramter:" + list.toString() + "; ");
			log.append("服务器异常:" + e.getMessage());
			return AjaxList.createError("服务器异常，请稍后重试", null);
		} finally {
			long endTime = System.currentTimeMillis();
			long costTime = endTime - startTime;
			log.append("costTime:" + costTime + "; ");
			if (!SUPPRESS_LOG_LIST.contains(methodFullName)) {
				ApiLoggerFactory.log().info(ApiLogger.class, "", transactionId, log.toString());
			} else {
				String suppressFactor = methodFullName + transactionId;
				ApiLoggerFactory.log().suppressInfo(ApiLogger.class, "", suppressFactor, transactionId, log.toString());
			}
		}
	}

}