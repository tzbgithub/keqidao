package com.qidao.qidao.wx.test;

import weixin.popular.api.SemanticAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.semantic.semproxy.SemproxySearch;
import weixin.popular.bean.semantic.semproxy.SemproxySearchResult;
import weixin.popular.bean.semantic.translatecontent.TranslatecontentResult;

public class SemanticDemo {
    String app_id = "wx8757750483ef5899";
    String app_secret = "ac2075e29477b9877b987ec145dbcb07";
    String accessToken = TokenAPI.token(app_id, app_secret).getAccess_token();
    //语义理解
    public void wordAnalyse() {
        SemproxySearch sps = new SemproxySearch();
        sps.setAppid("wx8757750483ef5899");
        sps.setCity("上海");
        sps.setQuery("请帮我查一下上海到广州的机票");
        sps.setCategory("flight,hotel");
        sps.setUid("123456");
        SemproxySearchResult ssr = SemanticAPI.semproxySearch(accessToken, sps);
        return;
    }

    //微信翻译
    public void translate() {
        TranslatecontentResult result = SemanticAPI.translatecontent(accessToken, "zh_CN", "en_US", "你好");
        return;
    }

    public static void main(String[] args) {

        SemanticDemo semantic = new SemanticDemo();

        semantic.translate();
    }

}


