package com.sysware.cloud.security.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * jwt登录成功后响应token对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;
    private String token;
}
