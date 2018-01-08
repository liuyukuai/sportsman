package com.sysware.cloud.utils.wechat;

/**
 * 常量类
 *
 * @author : liuyk
 */
public final class WxConstants {

    public static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN";

    public static final String CODE_KEY = "CODE";

    public static final String USER_ID_KEY = "USERID";

    // 微信appid
    public static final String CORP_ID = "wx12bfbc7b7f11c4ee";

    // 微信签名
    public static final String APP_SECRET = "9q7dzpGcd6m1qExsrEC5yklw_Xc8uK6Ly-zPOvBl4tg";

    // 微信获取userId
    public static final String WX_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORP_ID + "&corpsecret=" + APP_SECRET;

    // 微信获取USER请求地址
    public static final String WX_USER_BY_CODE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";

    // 微信获取USER请求地址
    public static final String WX_USER_ID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";

}
