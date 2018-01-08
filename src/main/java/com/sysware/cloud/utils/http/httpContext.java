package com.sysware.cloud.utils.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * http请求上下文
 *
 * @author : liuyk
 */
public class httpContext {

    // uri
    URI uri;

    // url
    String url;

    // 默认值
    String defaultValue = "";

    // 传输超时时间
    int socketTimeout = 2000;

    // 连接超时时间
    int connTimeout = 2000;

    // 参数
    List<NameValuePair> params = new ArrayList<NameValuePair>();

    // 头信息
    Map<String, String> headers = new HashMap<String, String>();

    httpContext() {
        // this.headers.put("Content-Type", "application/json;charset=utf-8");
    }

    /**
     * 设置url
     * 
     * @param url 请求url
     */
    httpContext setUrl(String url) {
        if (url == null || url.equals("")) {
            throw new IllegalArgumentException("url不能为空");
        }
        this.url = url;
        this.uri = this.process(url);
        return this;
    }

    /**
     * @author : liuyk
     * @param name 参数名称
     * @param value 参数值
     */
    httpContext setParam(String name, String value) {
        this.params.add(new BasicNameValuePair(name, value));
        return this;
    }

    /**
     * 设置传输超时时间
     * 
     * @param socketTimeout
     */
    httpContext setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        return this;
    }

    /**
     * 设置连接超时时间
     * 
     * @param connTimeout
     */
    httpContext setConnTimeout(int connTimeout) {
        this.connTimeout = connTimeout;
        return this;
    }

    /**
     * 批量设置参数
     *
     * @author : liuyk
     * @param params 批量参数集合
     */
    httpContext setParam(Map<String, String> params) {
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                this.params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return this;
    }

    /**
     * 重组参数
     * 
     * @author : liuyk
     */
    String genrateParams() {
        String params = "";
        for (NameValuePair nameValuePair : this.params) {
            params += (nameValuePair.getName() + "=" + nameValuePair.getValue() + "&");
        }
        if (!params.equals("")) {
            params = params.substring(0, params.length() - 1);
        }
        return params;
    }

    httpContext setHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public httpContext setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * 处理headers
     *
     * @param request
     */
    void setHandlerHeader(HttpRequestBase request) {
        // 设置用户自定义header
        if (this.headers.size() != 0) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                request.setHeader(key, headers.get(key));
            }
        }
    }

    URI urlAppendParam() {
        // 参数设置
        String params = this.genrateParams();
        // 判断url是否有？
        if (this.url.indexOf("?") != -1) {
            this.url += "&" + params;
        } else {
            this.url += "?" + params;
        }
        return process(this.url);
    }

    private URI process(String url) {
        try {
            URL _url = new URL(url);
            return new URI(_url.getProtocol(), null, _url.getHost(), _url.getPort(), _url.getPath(), _url.getQuery(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
