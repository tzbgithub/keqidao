package com.qidao.qidao.wx.datacube.service.impl;

import com.qidao.qidao.wx.constant.Env;
import com.qidao.qidao.wx.datacube.service.CustomeWxDataCubeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.user.UsercumulateResult;
import weixin.popular.bean.datacube.user.UsersummaryResult;

public class CustomWxDataCubeUserServiceImpl implements CustomeWxDataCubeUserService {

    @Autowired
    Env env;

    @Override
    public UsersummaryResult getusersummary( String beginDate, String endDate) {
        return DataCubeAPI.getusersummary(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UsercumulateResult getusercumulate( String beginDate, String endDate) {
        return DataCubeAPI.getusercumulate(env.getAccessToken(), beginDate, endDate);
    }
}
