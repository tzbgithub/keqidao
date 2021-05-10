package com.qidao.qidao.wx.datacube.service.impl;

import com.qidao.qidao.wx.datacube.service.CustomWxDataCubeArticleService;
import com.qidao.qidao.wx.constant.Env;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.article.ArticlesummaryResult;
import weixin.popular.bean.datacube.article.ArticletotalResult;
import weixin.popular.bean.datacube.article.UserreadResult;
import weixin.popular.bean.datacube.article.UsershareResult;

public class CustomWxDataCubeArticleServiceImpl implements CustomWxDataCubeArticleService {
    @Autowired
    Env env;

    @Override
    public ArticlesummaryResult getarticlesummary(String beginDate, String endDate) {
        return DataCubeAPI.getarticlesummary(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public ArticletotalResult getarticletotal(String beginDate, String endDate) {
        return DataCubeAPI.getarticletotal(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UserreadResult getuserread(String beginDate, String endDate) {
        return DataCubeAPI.getuserread(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UserreadResult getuserreadhour(String beginDate, String endDate) {
        return DataCubeAPI.getuserreadhour(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UsershareResult getusershare(String beginDate, String endDate) {
        return DataCubeAPI.getusershare(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UsershareResult getusersharehour(String beginDate, String endDate) {
        return DataCubeAPI.getusersharehour(env.getAccessToken(), beginDate, endDate);
    }

}
