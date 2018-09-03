package com.qianxx.qztaxi.webService.response;

/**
 * Description:
 * Created by ZoroJ on 2016/5/25.
 */
public class KindEditorResponse {

    private Integer error;
    private String message;
    private String url;

    public KindEditorResponse(Integer error, String message,String url) {
        this.error = error;
        this.message = message;
        this.url=url;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
