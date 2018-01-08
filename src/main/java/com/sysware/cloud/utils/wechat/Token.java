package com.sysware.cloud.utils.wechat;

import lombok.Data;

/**
 * 微信token对象
 *
 * @author : liuyk
 */
@Data
public class Token {
    private String errcode;

    private String errmsg;

    private String access_token;

    private String expires_in;

}
