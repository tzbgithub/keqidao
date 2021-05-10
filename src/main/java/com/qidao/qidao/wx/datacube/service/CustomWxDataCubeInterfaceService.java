package com.qidao.qidao.wx.datacube.service;

import weixin.popular.bean.datacube.interfaces.InterfacesummaryResult;

public interface CustomWxDataCubeInterfaceService {
    /**
     * 获取接口分析数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    InterfacesummaryResult getinterfacesummary(String beginDate, String endDate);
    /**
     * 获取接口分析分时数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    InterfacesummaryResult getinterfacesummaryhour(String beginDate, String endDate);

}

