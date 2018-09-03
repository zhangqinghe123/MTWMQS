package com.qianxx.qztaxi.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 用于构建web服务的错误对象
 * 
 * @author SummerSoft
 *
 */
public class RestError {

	/**
	 * http状态码
	 */
	private HttpStatus httpStatus;
	/**
	 * 错误码
	 */
	private int errorCode;
	/**
	 * 错误状态
	 */
	private String status;
	/**
	 * 错误信息
	 */
	private String message;
	/**
	 * 请求来源
	 */
	private String fromUri;

	public RestError() {

	}

	public RestError(HttpStatus httpStatus, int errorCode, String message,
			String fromUri, String status) {
		super();
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.message = message;
		this.fromUri = fromUri;
		this.status = status;
	}

	public String toString() {
		return new StringBuilder().append("HttpStatus:")
				.append(getHttpStatus().value()).append(" status:")
				.append(this.getStatus()).append(" errorCode:")
				.append(this.getErrorCode()).append(" errorMessage:")
				.append(this.getMessage()).append(" errorURL")
				.append(this.getFromUri()).toString();
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus
	 *            the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the fromUri
	 */
	public String getFromUri() {
		return fromUri;
	}

	/**
	 * @param fromUri
	 *            the fromUri to set
	 */
	public void setFromUri(String fromUri) {
		this.fromUri = fromUri;
	}
}
