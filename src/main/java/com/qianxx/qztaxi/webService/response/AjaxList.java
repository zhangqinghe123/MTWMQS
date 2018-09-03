package com.qianxx.qztaxi.webService.response;

import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.util.Constants;

/**
 * API返回类型DTO <br>
 * Created on 2016/3/24. <br>
 * @author linweihao
 */
public class AjaxList extends WsResponse {

	// 响应代码
	private String status;

	// 错误编码
	private Integer errCode;

	// 错误信息
	private String message;

	// 返回数据
	private Object data;

	public AjaxList() {
	}

	public AjaxList(String status, Integer errCode, String message, Object data) {
		this.status = status;
		this.errCode = errCode;
		this.message = message;
		this.data = data;
	}

	/**
	 * 返回正确状态的结果集<br>
	 * <p>作者：linweihao</p>
	 *
	 * @param message 提示消息
	 * @param data 结果集
	 * @return AjaxList JSON
	 */
	public static AjaxList createSuccess(String message, Object data) {
		return new AjaxList(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_0_SUCCESS, message, data);
	}

	/**
	 * 返回错误状态的结果集<br>
	 * <p>作者：linweihao</p>
	 *
	 * @param message 提示消息
	 * @param data 结果集
	 * @return AjaxList JSON
	 */
	public static AjaxList createError(String message, Object data) {
		return new AjaxList(Constants.API_STATUS_ERROR, ErrCodeConstants.ERR_1_ERROR, message, data);
	}

	/**
	 * 返回自定义状态的结果集<br>
	 * <p>作者：linweihao</p>
	 *
	 * @param status 状态码
	 * @param errCode 错误码
	 * @param message 提示消息
	 * @param data 结果集
	 * @return
	 */
	public static AjaxList createJsonDate(String status, Integer errCode, String message, Object data) {
		return new AjaxList(status, errCode, message, data);
	}

	/**
	 * <br>
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <br>
	 * <p>描述</p>
	 * <p>作者：linweihao</p>
	 *
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * <br>
	 * @return
	 */
	public Integer getErrCode() {
		return errCode;
	}

	/**
	 * <br>
	 * <p>描述</p>
	 * <p>作者：linweihao</p>
	 *
	 * @param errCode
	 */
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	/**
	 * <br>
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <br>
	 * <p>描述</p>
	 * <p>作者：linweihao</p>
	 *
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * <br>
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <br>
	 * <p>描述</p>
	 * <p>作者：linweihao</p>
	 *
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}
}

// ~ Formatted by Jindent --- http://www.jindent.com
