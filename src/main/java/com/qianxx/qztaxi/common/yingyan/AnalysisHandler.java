package com.qianxx.qztaxi.common.yingyan;

import com.alibaba.fastjson.JSONObject;
import com.qianxx.qztaxi.common.yingyan.api.analysis.StayPointRequest;
import com.qianxx.qztaxi.common.yingyan.api.track.IllegalTrackArgumentException;
import com.qianxx.qztaxi.common.yingyan.core.HttpClient;
import com.qianxx.qztaxi.common.yingyan.core.UrlDomain;
import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.YingYanConstants;
import com.qianxx.qztaxi.common.yingyan.util.CommonUtils;
import com.qianxx.qztaxi.common.yingyan.util.HttpUtils;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import org.apache.commons.collections.CollectionUtils;

/**
 * 分析处理器
 * <p>Title: AnalysisHandler</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月8日 上午9:12:57
 * @version 1.0.0
 */
public class AnalysisHandler {

	/**
	 * 停留时长分析
	 * @param request
	 * @return
	 */
	public static long stayPoint(StayPointRequest request) {
		long slowSpeedTime = 0;
		long startUnixTime = request.getStartTime();
		long endUnixTime = request.getEndTime();

		// 如果起始时长超过5分钟，分段计算停止时间
		long interval = endUnixTime - startUnixTime;
		if (interval > YingYanConstants.FRAGMENT_FIVE_HOURS) {
			for (int i = 0; i <= interval / YingYanConstants.FRAGMENT_FIVE_HOURS; i++) {
				long tmpStart = startUnixTime + i * YingYanConstants.FRAGMENT_FIVE_HOURS;
				long tmpEnd = startUnixTime + (i + 1) * YingYanConstants.FRAGMENT_FIVE_HOURS;
				if (tmpEnd > endUnixTime) {
					tmpEnd = endUnixTime;
				}
				request.setStartTime(tmpStart);
				request.setEndTime(tmpEnd);
				slowSpeedTime += requestStayPoint(request);
			}

		} else {
			slowSpeedTime += requestStayPoint(request);
		}
		return slowSpeedTime;
	}

	/**
	 * @param request
	 * @return
	 */
	private static long requestStayPoint(StayPointRequest request) {
		StringBuilder parameters = new StringBuilder();
		packRequest(request, parameters);
		String rspString = HttpClient.sendRequest(UrlDomain.ACTION_ANALYSIS_STAYPOINT, parameters.toString(), HttpClient.METHOD_GET);
		JSONObject stayPointRsp = JSONObject.parseObject(rspString);
		long slowSpeedTime = 0;
		if (new Integer(0).equals(stayPointRsp.getInteger("status")) && stayPointRsp.getInteger("staypoint_num") > 0 && !CollectionUtils.isEmpty(stayPointRsp.getJSONArray("stay_points"))) {
			for (Object t : stayPointRsp.getJSONArray("stay_points")) {
				JSONObject tmp = JSONObject.parseObject(String.valueOf(t));
				slowSpeedTime += tmp.getLongValue("duration");
			}
		} else {
			ApiLoggerFactory.log().error(AnalysisHandler.class, "requestStayPoint", "", rspString);
		}
		return slowSpeedTime;
	}

	/**
	* 组装请求
	* 
	* @return
	*/
	public static void packRequest(BaseRequest request, StringBuilder parameters) {
		if (null == request) {
			throw new IllegalTrackArgumentException("request can not be null.");
		}
		CommonUtils.packCommonRequest(parameters);
		if (request instanceof StayPointRequest) {
			StayPointRequest stayPointRequest = (StayPointRequest) request;
			parameters.append("&entity_name=").append(HttpUtils.urlEncode(stayPointRequest.getEntityName()));
			parameters.append("&start_time=").append(stayPointRequest.getStartTime());
			parameters.append("&end_time=").append(stayPointRequest.getEndTime());
			parameters.append("&stay_time=").append(stayPointRequest.getStayTime());
			parameters.append("&stay_radius=").append(stayPointRequest.getStayRadius());
		}
	}
}
