package com.sysware.cloud.utils.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;

/**
 * httpclient
 *
 * @author : liuyk
 */
public class HttpClient extends AbstractHttpClient {

    private static Logger logger = LoggerFactory.getLogger(AbstractHttpClient.class);

    private static CloseableHttpClient httpClient;

    static {
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
    }

    @Override
    public CloseableHttpClient createClient() {
        return httpClient;
    }

    protected HttpClient(httpContext context) {
        this.context = context;
    }

    public static HttpClient newInstance() {
        return new HttpClient(new httpContext());
    }

    /**
     * 下载文件
     *
     * @return
     */
    @Override
    public InputStream downloadFile() {
        return null;
    }

    @Override
    public String uploadFile(File... files) {
        return null;
    }

    @Override
    public String uploadFile(InputStream is, String fileName) {
      return null;
    }
}
