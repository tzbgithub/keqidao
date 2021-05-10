package com.qidao.qidao.wx.datacube.service.impl;

import com.qidao.qidao.wx.datacube.service.CustomWxDataCubeInterfaceService;
import com.qidao.qidao.wx.constant.Env;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.interfaces.InterfacesummaryResult;

public class CustomWxDataCubeInterfaceServiceImpl implements CustomWxDataCubeInterfaceService {
    @Autowired
    Env env;
    @Override
    public InterfacesummaryResult getinterfacesummary(String beginDate, String endDate) {
        return DataCubeAPI.getinterfacesummary(env.getAccessToken(), beginDate, endDate);
    }

    @Override
    public InterfacesummaryResult getinterfacesummaryhour(String beginDate, String endDate) {
        return DataCubeAPI.getinterfacesummaryhour(env.getAccessToken(), beginDate, endDate);
    }
}
