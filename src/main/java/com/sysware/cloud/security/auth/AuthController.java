package com.sysware.cloud.security.auth;

import com.sysware.cloud.security.config.WxAuthenticationRequest;
import com.sysware.cloud.security.config.WxAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    private AuthService authService;


    /**
     * 登录获取token的值
     *
     * @param authenticationRequest 登录信息
     * @return
     * @throws AuthenticationException
     */
    @PostMapping(value = "/auth/token")
    public ResponseEntity<String> doAuth(
            @RequestBody WxAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        return ResponseEntity.ok(token);
    }

    /**
     * 刷新token的值
     *
     * @param request
     * @return
     * @throws AuthenticationException
     */
    @GetMapping(value = "/auth/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new WxAuthenticationResponse(refreshedToken));
        }
    }

    @PostMapping(value = "/auth/invalid")
    public ResponseEntity<?> invalid(@RequestHeader("Authorization") String token){
        //authService.invalid(token);
        return ResponseEntity.ok(true);
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
