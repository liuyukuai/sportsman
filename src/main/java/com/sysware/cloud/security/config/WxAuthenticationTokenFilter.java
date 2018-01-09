package com.sysware.cloud.security.config;

import com.sysware.cloud.utils.wechat.UserInfo;
import com.sysware.cloud.utils.wechat.WxUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登录认证过滤器
 */
@Component
@SuppressWarnings("SpringJavaAutowiringInspection")
public class WxAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
//        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        StringBuffer url = httpRequest.getRequestURL();
//        System.out.println("url:"+ url);
//        String paramState = httpRequest.getParameter("state");
//        String paramCode = httpRequest.getParameter("code");
//        if(authentication==null &&  StringUtils.isNotBlank(paramState) && StringUtils.isNotBlank(paramCode)){
//            UserInfo userInfo = WxUtils.getUserByCode(paramCode);
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                    userInfo, null, userInfo.getAuthorities());
//            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        }
        chain.doFilter(request, response);
    }
}
