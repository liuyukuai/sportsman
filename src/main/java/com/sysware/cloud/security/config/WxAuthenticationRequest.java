package com.sysware.cloud.security.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * jwt登录请求对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = -8445943548965154778L;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;

}
