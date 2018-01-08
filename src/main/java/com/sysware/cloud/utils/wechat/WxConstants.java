package com.sysware.cloud.utils.wechat;

/**
 * 常量类
 *
 * @author : liuyk
 */
public final class WxConstants {

    // 微信appid
    public static final String CORP_ID = "wx12bfbc7b7f11c4ee";

    // 微信签名
    public static final String APP_SECRET = "9q7dzpGcd6m1qExsrEC5yklw_Xc8uK6Ly-zPOvBl4tg";

    // 微信获取token的url
    public static final String WX_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORP_ID + "&corpsecret=" + APP_SECRET;

    // 微信获取USER请求地址
    public static final String WX_USER_ID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";

    // 微信根据openi获取用户信息
    public static final String WX_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";

    // 批量获取用户信息
    public static final String WX_USER_INFO_BATCH_URL = " https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

    // 微信模板消息发送url
    public static final String WX_SEND_TEMPLATE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

}
