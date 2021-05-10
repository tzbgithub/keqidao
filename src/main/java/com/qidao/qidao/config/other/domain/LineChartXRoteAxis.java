package com.qidao.qidao.config.other.domain;

import lombok.Getter;

import java.util.List;

/**
 * 折线图 X轴数据
 */
@Getter
public class LineChartXRoteAxis {
    /**
     * x 轴坐标数据
     * 例： ['周一','周二','周三','周四','周五','周六','周日']
     */
    private List<String> data;
    /**
     * 固定值：category
     */
    private String type;

    public LineChartXRoteAxis(List<String> data) {
        this.type = "category";
        this.data = data;
    }
}
