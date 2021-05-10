package com.qidao.qidao.wx.test;

import weixin.popular.api.ComponentAPI;
import weixin.popular.api.ShorturlAPI;
import weixin.popular.api.SnsAPI;
import weixin.popular.api.TokenAPI;


public class AuthDemo {
    String app_id = "wx8757750483ef5899";
    String app_secret = "ac2075e29477b9877b987ec145dbcb07";

    String accessToken = TokenAPI.token(app_id, app_secret).getAccess_token();
    String redirect_url = "http://gqvr9i.natappfree.cc";
    String openid = "oCJyZ58vcJpMDj8vl2JYy5qWwY24";

    //生成需要用户点击授权的url
    public String method() {
        return SnsAPI.connectOauth2Authorize(app_id, redirect_url, true, null);
    }
}
