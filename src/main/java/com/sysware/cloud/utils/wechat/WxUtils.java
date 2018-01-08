package com.sysware.cloud.utils.wechat;

import com.google.common.cache.*;
import com.sysware.cloud.utils.http.HttpClient;
import com.sysware.cloud.utils.json.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * 微信操作类
 *
 * @author : liuyk
 */
@Slf4j
public class WxUtils {

   private static  LoadingCache<String,String> TOKEN_CACHE
            = CacheBuilder.newBuilder()
            //设置并发级别为1，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(1)
            //设置写缓存后1个小时过期
            .expireAfterWrite(1, TimeUnit.HOURS)
            //设置缓存容器的初始容量为10
            .initialCapacity(1)
            //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
            .maximumSize(10)
            //设置要统计缓存的命中率
            .recordStats()
            //设置缓存的移除通知
            .removalListener((notification) -> {
                log.info(notification.getKey() + " was removed, cause is " + notification.getCause());
            })
            //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(new CacheLoader<String, String>() {
                       @Override
                       public String load(String key) {
                           System.setProperty("jsse.enableSNIExtension", "false");
                           String string = HttpClient.newInstance().setUrl(WxConstants.WX_TOKEN_URL).get();
                           if (StringUtils.isNotBlank(string)) {
                               Token token = GsonUtils.toBean(string, Token.class);
                               return token == null ? null : token.getAccess_token();
                           }
                           return null;
                       }
                   }
            );

    /**
     * 获取认证信息
     */
    private static String getToken() {
        try {
            return TOKEN_CACHE.get("token");
        }catch (Exception e) {
            log.error(e.getMessage(),e);
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(WxUtils.getToken());
	}
}
