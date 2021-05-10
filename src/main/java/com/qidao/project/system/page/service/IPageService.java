package com.qidao.project.system.page.service;

import com.qidao.qidao.config.other.domain.IndexCountRes;
import com.qidao.qidao.config.other.domain.IndexLineChart;

import java.time.LocalDateTime;

public interface IPageService {
    /**
     * 首页数据统计
     * @param beginTime 查询开始时间
     * @param endTime 结束时间
     * @return 昨日数据封装对象
     */
    IndexCountRes indexCount(LocalDateTime beginTime, LocalDateTime endTime);

    /**
     * 首页 折线图
     * @param recentDay 查询范围 （天）
     * @return echart 图表数据
     */
    IndexLineChart indexLineChart(Integer recentDay);
}
