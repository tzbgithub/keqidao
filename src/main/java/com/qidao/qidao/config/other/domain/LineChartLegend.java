package com.qidao.qidao.config.other.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 指明每条折线的图例
 */
@Data
@AllArgsConstructor
public class LineChartLegend {
    /**
     * 和 series name 保持一致
     */
    private List<String> data;
}
