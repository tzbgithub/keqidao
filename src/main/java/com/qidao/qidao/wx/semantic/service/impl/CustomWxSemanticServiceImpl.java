package com.qidao.qidao.wx.semantic.service.impl;

import com.qidao.qidao.wx.semantic.service.CustomWxSemanticSevice;
import com.qidao.qidao.wx.constant.Env;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.SemanticAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.semantic.semproxy.SemproxySearch;

public class CustomWxSemanticServiceImpl implements CustomWxSemanticSevice {
    @Autowired
    Env env;
    @Override
    public BaseResult semproxySearch(SemproxySearch semproxySearch) {
        return SemanticAPI.semproxySearch(env.getAccessToken(), semproxySearch);
    }

    @Override
    public BaseResult translatecontent(String lfrom, String ito, String content) {
        return SemanticAPI.translatecontent(env.getAccessToken(), lfrom, ito, content);
    }
}
