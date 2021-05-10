package com.qidao.qidao.wx.datacube.service.impl;

import com.qidao.qidao.wx.constant.Env;
import com.qidao.qidao.wx.datacube.service.CustomWxDataCubeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.upstreammsg.UpstreammsgResult;

public class CustomWxDataCubeMessageServiceImpl implements CustomWxDataCubeMessageService {
    @Autowired
    Env env;

    @Override
    public UpstreammsgResult getupstreammsg(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsg(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsghour(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsghour(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsgweek(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsgweek(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsgmonth(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsgmonth(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsgdist(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsgdist(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsgdistweek(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsgdistweek(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public UpstreammsgResult getupstreammsgdistmonth(String beginDate, String endDate) {
        return DataCubeAPI.getupstreammsgdistmonth(env.getAccessToken(), beginDate, endDate);
    }
}
