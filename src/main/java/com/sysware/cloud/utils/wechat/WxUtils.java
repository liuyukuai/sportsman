package com.sysware.cloud.utils.wechat;

import com.google.common.cache.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sysware.cloud.utils.http.HttpClient;
import com.sysware.cloud.utils.http.HttpsClient;
import com.sysware.cloud.utils.json.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 微信操作类
 *
 * @author : liuyk
 */
@Slf4j
@Component
public class WxUtils implements UserDetailsService {

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

    /**
     *
     * @param code
     * @return
     */
    public static UserInfo getUserByCode(String code) {
        if(StringUtils.isNotBlank(code)) {
            String userJson = HttpsClient.newInstance().setUrl(WxConstants.WX_USER_BY_CODE_URL.replace(WxConstants.ACCESS_TOKEN_KEY,getToken()).replace(WxConstants.CODE_KEY,code)).get();
            JsonObject jsonObject = GsonUtils.toJson(userJson);
            return getUserById(jsonObject.get("UserId").getAsString());
        }
        return null;
    }



    public static UserInfo getUserById(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            String userJson = HttpsClient.newInstance().setUrl(WxConstants.WX_USER_ID_URL.replace(WxConstants.ACCESS_TOKEN_KEY, getToken()).replace(WxConstants.USER_ID_KEY, userId)).get();
            JsonObject jsonObject = GsonUtils.toJson(userJson);
            try {
                UserInfo userInfo = new UserInfo();
                List<String> departments = new ArrayList<>();
                JsonArray deptArray = jsonObject.getAsJsonArray("department");
                for(int i = 0; i < deptArray.size(); i ++) {
                    departments.add(deptArray.get(i).toString());
                }
                userInfo.setDepartments(departments);
                userInfo.setEmail(jsonObject.get("email").getAsString());
                userInfo.setGender(jsonObject.get("gender").getAsString());
                userInfo.setMobile(jsonObject.get("mobile").getAsString());
                userInfo.setPhoto(jsonObject.get("avatar").getAsString());

                //TODO 角色处理

                return userInfo;
            } catch (Exception e) {
                log.error(e.getMessage(),e);
                return null;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
      return WxUtils.getUserByCode(code);
    }

    public static void main(String[] args) {
        System.out.println(WxUtils.getToken());
	}
}
