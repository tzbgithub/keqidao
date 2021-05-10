package com.qidao.qidao.wx.datacube.service;

import weixin.popular.bean.datacube.upstreammsg.UpstreammsgResult;

public interface CustomWxDataCubeMessageService {

    /**
     * 获取消息发送概况数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsg(String beginDate, String endDate);

    /**
     * 获取消息分送分时数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsghour(String beginDate, String endDate);

    /**
     * 获取消息发送周数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsgweek(String beginDate, String endDate);

    /**
     * 获取消息发送月数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsgmonth(String beginDate, String endDate);

    /**
     * 获取消息发送分布数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsgdist(String beginDate, String endDate);

    /**
     * 获取消息发送分布周数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsgdistweek(String beginDate, String endDate);

    /**
     * 获取消息发送分月周数据
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    UpstreammsgResult getupstreammsgdistmonth(String beginDate, String endDate);




    public static void main(String[] args) {
//        UpstreammsgResult getupstreammsghour = DataCubeAPI.();
    }
}
