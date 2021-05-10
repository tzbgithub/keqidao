package com.qidao.qidao.config.other.domain;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页拆线图 封装
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndexLineChart {
    /**
     * x轴 坐标
     */
    private List<LineChartXRoteAxis> xAxis;

    /**
     * 数据集合
     */
    private List<LineChartSeries> series;

    /**
     * 图表名称
     */
    private String title;

    /**
     * 图例
     */
    private LineChartLegend legend;

    /**
     * 生成 legend 图例
     */
    public IndexLineChart initLegend(){
        if(CollUtil.isEmpty(series)) {
            return this;
        }
        List<String> data = series.stream().map(LineChartSeries::getName).collect(Collectors.toList());
        if (null == legend) {
            legend = new LineChartLegend(data);
        } else {
            legend.setData(data);
        }
        return this;
    }
}
