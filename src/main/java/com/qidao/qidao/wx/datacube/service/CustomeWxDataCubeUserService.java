package com.qidao.qidao.wx.datacube.service;

import weixin.popular.bean.datacube.user.UsercumulateResult;
import weixin.popular.bean.datacube.user.UsersummaryResult;

public interface CustomeWxDataCubeUserService {
    /**
     *获取用户增减数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UsersummaryResult getusersummary( String beginDate, String endDate);

    /**
     * 获取累计用户数据
     * @param beginDate
     * @param endDate
     * @return
     */
    UsercumulateResult getusercumulate( String beginDate, String endDate);



}
