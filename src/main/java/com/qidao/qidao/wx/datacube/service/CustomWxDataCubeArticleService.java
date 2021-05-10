package com.qidao.qidao.wx.datacube.service;

import weixin.popular.bean.datacube.article.ArticlesummaryResult;
import weixin.popular.bean.datacube.article.ArticletotalResult;
import weixin.popular.bean.datacube.article.UserreadResult;
import weixin.popular.bean.datacube.article.UsershareResult;

public interface CustomWxDataCubeArticleService {
    /**
     * 获取图文群发每日数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    ArticlesummaryResult getarticlesummary( String beginDate, String endDate);

    /**
     * 获取图文群发总数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    ArticletotalResult getarticletotal( String beginDate, String endDate);

    /**
     * 获取图文统计数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UserreadResult getuserread( String beginDate, String endDate);


    UserreadResult getuserreadhour(String beginDate, String endDate);

    /**
     * 获取图文分享转发数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UsershareResult getusershare(String beginDate, String endDate);

    /**
     * 获取图文分享转发分时数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate   获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UsershareResult getusersharehour(String beginDate, String endDate);


    public static void main(String[] args) {
//        UsershareResult getuserread = DataCubeAPI.getusersharehour();
    }
}

