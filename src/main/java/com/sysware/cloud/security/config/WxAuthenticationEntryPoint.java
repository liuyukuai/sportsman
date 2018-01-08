package com.sysware.cloud.security.config;

import com.sysware.cloud.utils.wechat.WxConstants;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;


/**
 * security 没有权限处理端点
 * 前后台分离项目没有登录页面，通过response返回没有权限或者没有登录的状态。
 * 这个抛出的异常，全局异常处理不了。
 *
 */
@Component
public class WxAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        StringBuffer url = httpRequest.getRequestURL();
        if (httpRequest.getQueryString() != null) {
            url.append('?');
            url.append(httpRequest.getQueryString());
        }
        httpResponse.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ WxConstants.CORP_ID+"&redirect_uri=" + url.toString() + "&response_type=code&scope=snsapi_base&state=weioa#wechat_redirect");
    }
}
