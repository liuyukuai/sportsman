package com.sysware.cloud.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 响应结果对象
 * 
 * @author liuyk
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {

    /* 请求超时特殊错误编码 */
    public static final int TIME_OUT_EXCEPTION = -1;

    private static final long serialVersionUID = -3212041374480698935L;

    private static Logger logger = LoggerFactory.getLogger(Response.class);

    private boolean success;

    private T data;

    /* 错误编码 */
    private int code;

    private String msg;

    /* private */
    private Response() {}

    /* private */
    private Response(T data) {
        this.success = true;
        this.data = data;
    }

    /* private */
    private Response(boolean success, String msg) {
        this(success, msg, 0);
    }

    /* private */
    private Response(boolean success, String msg, int code) {
        this.msg = msg;
        this.success = success;
        this.code = code;
    }

    /**
     * 构建成功对象
     */
    public static <E> Response<E> success() {
        return new Response<E>(null);
    }

    /**
     * 构建成功对象
     * 
     * @param data
     */
    public static <E> Response<E> success(E data) {
        // if (data == null) {
        // return new Response<E>(false, "");
        // }
        return new Response<E>(data);
    }

    /**
     * 构建失败对象
     * 
     * @param data
     */
    public static <E> Response<E> error(String msg) {
        return new Response<E>(false, msg);
    }

    /**
     * 构建失败对象
     * 
     * @param data
     */
    public static <E> Response<E> error(String msg, int code) {
        return new Response<E>(false, msg);
    }

    /**
     * 构建简单true or false对象
     * 
     * @param data
     */
    public static Response<Boolean> bulid(Boolean success) {
        if (Objects.equal(success, Boolean.TRUE)) {
            return new Response<Boolean>(Boolean.TRUE);
        }
        return new Response<Boolean>(false, "");
    }

    /**
     * 解析Response对象,用于不关注错误消息的处理
     * 
     * @param response
     * @return
     */
    public static <E> E analyze(Response<E> response) {
        return analyze(response, null);
    }

    /**
     * 解析Response对象,获取错误消息
     * 
     * @param response
     * @return
     */
    public static <E> String msg(Response<E> response) {
        String msg = response.getMsg();
        if (!response.isSuccess()) {
            logger.info("调用接口失败  msg={}", msg);
        }
        return msg;
    }

    /**
     * 解析Response对象,用于不关注错误消息的处理
     * 
     * @param response
     * @param defaultValue 调用失败默认值
     * @return
     */
    public static <E> E analyze(Response<E> response, E defaultValue) {
        logger.info("调用接口,  response={}", response);
        // 处理代码返回值对象为空的情况
        if (response == null) {
            // 错误编码.
            logger.error("response is null.");
            return defaultValue;
        }

        if (response.isSuccess()) {
            E result = response.getData();
            if (result == null) {
                return defaultValue;
            }
            return result;
        }
        logger.info("调用接口失败  msg={}", response.getMsg());
        return defaultValue;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Response [success=" + success + ", data=" + data + ", code=" + code + ", msg=" + msg + "]";
    }
}
