package com.qianxx.qztaxi.common.callmembersys.message;

import com.alibaba.fastjson.JSONObject;

/**
 * 调用会员中心响应信息
 * <p>Title: MessageResult</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p>
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * @author zhangqinghe
 * @version 1.0.0
 * @date 2018年1月30日 下午1:20:50
 */
public class MessageResult<T> {

    // 错误描述（必选）
    private String code = new String();

    // httpCode(必选)
    private String msg = new String();

    // 会员中心携带的响应信息。
    private T data = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 判断响应是否成功
     *
     * @return
     */
    public boolean success() {
        return null != code && "200".equals(code);
    }

}
