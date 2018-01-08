package com.sysware.cloud.security.auth;

import com.sysware.cloud.security.config.WxTokenUtil;
import com.sysware.cloud.security.config.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private WxTokenUtil wxTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            WxTokenUtil wxTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.wxTokenUtil = wxTokenUtil;
    }

    @Override
    public String login(String email, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(email, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final WxUser userDetails = (WxUser)userDetailsService.loadUserByUsername(email);
        return wxTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = wxTokenUtil.getUsernameFromToken(token);
        WxUser user = (WxUser) userDetailsService.loadUserByUsername(username);
        if (wxTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return wxTokenUtil.refreshToken(token);
        }
        return null;
    }
}
