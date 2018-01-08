package com.sysware.cloud.utils.http;

import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Http连接工具类
 * 
 * @author : liuyk
 */
public abstract class AbstractHttpClient {

    private static Logger logger = LoggerFactory.getLogger(AbstractHttpClient.class);

    protected httpContext context;

    // 最大连接数
    protected static final int maxTotalConn = 50;

    // 单路由最大连接数
    protected static final int maxPerRoute = 5;

    // 创建http连接池管理
    protected static PoolingHttpClientConnectionManager cm;

    public abstract CloseableHttpClient createClient();

    static {
        // 创建http连接池管理
        cm = new PoolingHttpClientConnectionManager();
        // 设置最大连接数据 所有路由连接数之和 默认为20
        cm.setMaxTotal(maxTotalConn);
        // 设置每个路由上的基础连接数 默认为2
        cm.setDefaultMaxPerRoute(maxPerRoute);
    }

    public AbstractHttpClient setUrl(String url) {
        this.context.setUrl(url);
        return this;
    }

    /**
     * @author : liuyk
     * @param name 参数名称
     * @param value 参数值
     */
    public AbstractHttpClient setParam(String name, String value) {
        this.context.setParam(name, value);
        return this;
    }

    /**
     * 批量设置参数
     *
     * @author : liuyk
     * @param params 批量参数集合
     */
    public AbstractHttpClient setParam(Map<String, String> params) {
        this.context.setParam(params);
        return this;
    }

    public AbstractHttpClient setHeader(String key, String value) {
        this.context.setHeader(key, value);
        return this;
    }

    public AbstractHttpClient setDefaultValue(String value) {
        this.context.setDefaultValue(value);
        return this;
    }

    /**
     * 设置传输超时时间
     * 
     * @param socketTimeout
     */
    public AbstractHttpClient setSocketTimeout(int socketTimeout) {
        this.context.setSocketTimeout(socketTimeout);
        return this;
    }

    /**
     * 设置连接超时时间
     * 
     * @param connTimeout
     */
    public AbstractHttpClient setConnTimeout(int connTimeout) {
        this.context.setConnTimeout(connTimeout);
        return this;
    }

    /**
     * 配置请求配置
     */
    private RequestConfig createConfig() {
        return RequestConfig.custom().setSocketTimeout(this.context.socketTimeout).setConnectTimeout(this.context.connTimeout).build();// 设置请求和
    }

    /**
     * 下载文件
     */
    public abstract InputStream downloadFile();

    /**
     * 上传文件
     */
    public abstract String uploadFile(File... file);

    /**
     * 流文件
     */
    public abstract String uploadFile(InputStream is, String fileName);

    /**
     * 发送post请求
     *
     * @return
     */
    public String post() {
        String content = null;
        CloseableHttpResponse response = null;
        HttpPost post = null;
        HttpEntity entity = null;
        try {
            post = new HttpPost(this.context.uri);
            post.setConfig(this.createConfig());
            // 设置用户自定义header
            this.context.setHandlerHeader(post);
            if (this.context.params.size() != 0) {
                post.setEntity(new UrlEncodedFormEntity(this.context.params, Consts.UTF_8));
            }
            response = this.createClient().execute(post);
//            logger.debug("DefaultHttpHandler excute httpost begin - url:" + this.context.url + " -  params:" + new Gson().toJson(this.context.params));
            logger.debug("DefaultHttpHandler excute httpost begin - url:{} - params:{}", this.context.url,  new Gson().toJson(this.context.params));
            entity = response.getEntity();
            content = EntityUtils.toString(entity);
            // 关闭底层资源
            logger.debug("DefaultHttpHandler excute httpost end - result:{}", content);
            return content;
        } catch (Exception e) {
            logger.error("DefaultHttpHandler excute httpost error - :", e);
            return this.context.defaultValue;
        } finally {
            try {
                this.close(response);
                this.close(post);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String get() {
        String content = null;
        CloseableHttpResponse response = null;
        HttpGet get = null;
        HttpEntity entity = null;
        try {
            get = new HttpGet(this.context.urlAppendParam());
            get.setConfig(this.createConfig());
            // 设置用户自定义header
            this.context.setHandlerHeader(get);
            response = this.createClient().execute(get);
//            logger.debug("DefaultHttpHandler excute httpost begin - url:" + this.context.url + " - params:" + new Gson().toJson(this.context.params));
            logger.debug("DefaultHttpHandler excute httpost begin - url:{} - params:{}" ,this.context.url, new Gson().toJson(this.context.params));
            entity = response.getEntity();
            content = EntityUtils.toString(entity);
            // 关闭底层资源
            logger.debug("DefaultHttpHandler excute httpost end - result:{}", content);
            return content;
        } catch (Exception e) {
            logger.error("DefaultHttpHandler excute httpost error - :{}", e);
            return this.context.defaultValue;
        } finally {
            try {
                this.close(response);
                this.close(get);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String put() {
        String content = null;
        CloseableHttpResponse response = null;
        HttpPut put = null;
        HttpEntity entity = null;
        try {
            put = new HttpPut(this.context.uri);
            put.setConfig(this.createConfig());
            this.context.setHandlerHeader(put);
            if (this.context.params.size() != 0) {
                put.setEntity(new UrlEncodedFormEntity(this.context.params));
            }
            response = this.createClient().execute(put);
            logger.debug("DefaultHttpHandler excute httpost begin - url:{} - params:{}", context.url,  new Gson().toJson(context.params));
            entity = response.getEntity();
            content = EntityUtils.toString(entity);
            logger.debug("DefaultHttpHandler excute httpost end - result:{}", content);
            EntityUtils.consume(entity);
            return content;
        } catch (Exception e) {
            logger.error("DefaultHttpHandler excute httpost error - :{}", e);
            return this.context.defaultValue;
        } finally {
            try {
                this.close(response);
                this.close(put);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String post(String body) {
        String content = null;
        CloseableHttpResponse response = null;
        HttpPost post = null;
        HttpEntity entity = null;
        try {
            post = new HttpPost(this.context.urlAppendParam());
            post.setConfig(this.createConfig());
            this.context.setHandlerHeader(post);
            if (body != null) {
                post.setEntity(new ByteArrayEntity(body.getBytes("UTF-8")));
            }
            response = this.createClient().execute(post);
            logger.debug("DefaultHttpHandler excute httpost begin - url:{} - params:{}", context.url,  new Gson().toJson(this.context.params));
            entity = response.getEntity();
            content = EntityUtils.toString(entity);
            logger.debug("DefaultHttpHandler excute httpost end - result:{}", content);
            return content;
        } catch (Exception e) {
            logger.error("DefaultHttpHandler excute httpost error - :", e);
            return this.context.defaultValue;
        } finally {
            try {
                this.close(response);
                this.close(post);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String delete() {
        String content = null;
        CloseableHttpResponse response = null;
        HttpDelete delete = null;
        HttpEntity entity = null;
        try {
            delete = new HttpDelete(this.context.urlAppendParam());
            delete.setConfig(this.createConfig());
            response = this.createClient().execute(delete);
            logger.debug("DefaultHttpHandler excute httpdelete begin - url:{} - params:{}", context.url, new Gson().toJson(this.context.params));
            entity = response.getEntity();
            content = EntityUtils.toString(entity);
            logger.debug("DefaultHttpHandler excute httpdelete end - result:{}", content);
            return content;
        } catch (Exception e) {
            logger.error("DefaultHttpHandler excute httpdelete error - :{}", e);
            return this.context.defaultValue;
        } finally {
            try {
                this.close(response);
                this.close(delete);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(HttpRequestBase request) {
        if (request != null) {
            request.reset();
        }
    }

    public httpContext getContext() {
        return context;
    }
}
