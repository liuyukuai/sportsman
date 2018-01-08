package com.sysware.cloud.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

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
public class WeChatAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
//        Response rs = Response.error("您没有权限访问该") ;
//        rs.setCode(401);
//        response.getWriter().write(GsonUtils.toJson(rs));
    }
}
