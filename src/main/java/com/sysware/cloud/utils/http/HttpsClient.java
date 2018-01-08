package com.sysware.cloud.utils.http;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * https工具类
 *
 * @author : liuyk
 */
@SuppressWarnings("deprecation")
public class HttpsClient extends AbstractHttpClient {

    private static CloseableHttpClient httpClient;

    static {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslsf).build();
            cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            cm.setMaxTotal(maxTotalConn);
            cm.setDefaultMaxPerRoute(maxPerRoute);
            httpClient = HttpClients.custom().setConnectionManager(cm).setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CloseableHttpClient createClient() {
        return httpClient;
    }

    private HttpsClient(httpContext context) {
        this.context = context;
    }

    public static HttpsClient newInstance() {
        return new HttpsClient(new httpContext());
    }

    @Override
    public InputStream downloadFile() {
        return null;
    }

    @Override
    public String uploadFile(File... file) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(HttpsClient.newInstance().setUrl("https://192.168.4.123").post());
    }

    @Override
    public String uploadFile(InputStream is, String fileName) {
        // TODO Auto-generated method stub
        return null;
    }
}
