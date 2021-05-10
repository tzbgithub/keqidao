package com.qidao.qidao.wx.test;

import weixin.popular.api.CustomserviceAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.customservice.KFAccount;

//客服管理（官方没有对测试号开发客服接口）
public class Customservice {

    String app_id = "wx8757750483ef5899";
    String app_secret = "ac2075e29477b9877b987ec145dbcb07";
    String accessToken = TokenAPI.token(app_id, app_secret).getAccess_token();

    //添加客服账号
    public void method0() {
        CustomserviceAPI.kfaccountAdd(accessToken, "test1@test", "客服", "pswmd5");
        return;
    }

    //获取客服基本信息
    public void method() {
        KFAccount kfa = CustomserviceAPI.getkflist(accessToken);
        return;
    }

}
