package com.qianxx.qztaxi.common.exception;

public class RestServiceException extends RuntimeException {

	private String status;
	private int errorCode;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4854901217206974677L;

	public RestServiceException() {
	}

	public RestServiceException(String message) {
		super(message);
		this.errorCode = 1; // 未知错误
		this.status = "0"; // 未知错误
	}

	public RestServiceException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public RestServiceException(String message, int errorCode, String status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

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
	 *            the errorStatus to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
