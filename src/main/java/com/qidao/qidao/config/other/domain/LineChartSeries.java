package com.qidao.qidao.config.other.domain;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 折线图数据封装
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineChartSeries {
    //    {
//        name:'数据AA',
//                type:'line',
//            data:[1, -2, 2, 5, 3, 2, 0,10],
//        markLine : {
//            data : [
//            {type : 'average', name : '平均值'}
//                        ]
//        }
//    }
    /**
     * 折线数据名称
     */
    private String name;
    /**
     * 折线类型：固定值 line
     */
    private String type;
    /**
     * 折线具体数据
     * 例 ： [1, -2, 2, 5, 3, 2, 0,10]
     */
    private List<Integer> data;
    /**
     * 标记点
     */
    private MarkPoint markPoint;

    public static LineChartSeries getInstance(String name, List<Integer> data){
        return new LineChartSeries(name, data, false);
    }

    public static LineChartSeries getInstance(String name, List<Integer> data,boolean markMax){
        return new LineChartSeries(name, data, markMax);
    }

    private LineChartSeries (String name, List<Integer> data,boolean markMax) {
        this.name = name;
        this.data = data;
        this.type = "line";
        if(markMax) {
            this.markPoint = this.new MarkPoint("最大值","max");
        }
    }

    /**
     * 标记点信息
     */
    @Data
    private class MarkPoint {
        /**
         * 标记点集合
         */
        List<MarkPointData> data;

        MarkPoint (String dataName, String dataType){
            MarkPointData data = new MarkPointData();
            data.name = dataName;
            data.type = dataType;
            this.data = Collections.singletonList(data);
        }
    }

    /**
     * 标记点 位置信息
     */
    @Data
    private class MarkPointData {
        /**
         * 类型
         * max : 最大
         * min : 最小
         * average : 平均值
         */
        private String type;
        /**
         * 在图片上的展示信息
         */
        private String name;
    }


}
