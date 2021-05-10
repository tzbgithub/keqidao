package com.qidao.project.system.page.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import com.qidao.project.system.page.enums.IndexChartEnum;
import com.qidao.qidao.config.other.domain.*;
import com.qidao.qidao.config.other.mapper.CustomOtherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PageServiceImpl implements IPageService{

    @Resource
    private CustomOtherMapper customOtherMapper;

    @Override
    public IndexCountRes indexCount(LocalDateTime beginTime, LocalDateTime endTime) {
        return customOtherMapper.indexCount(beginTime,endTime);
    }

    @Override
    public IndexLineChart indexLineChart(Integer recentDay) {
        LocalDate now = LocalDate.now();
        LocalDate beginDay = now.minusDays(recentDay);
        LocalDateTime.now().format(DatePattern.NORM_DATETIME_FORMATTER);

        List<IndexChartDAO> chartDataDbList = customOtherMapper.queryLineChart(recentDay);
        Map<Integer, List<IndexChartDAO>> chartDataDbMap = chartDataDbList.stream()
                .collect(Collectors.groupingBy(IndexChartDAO::getType));

        Map<String, Integer> memberDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.MEMBER);
        Map<String, Integer> enterpriseDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.ENTERPRISE);
        Map<String, Integer> labDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.LAB);
        Map<String, Integer> dynamicDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.DYNAMIC);
        Map<String, Integer> serverDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.SERVER);
        Map<String, Integer> contractDataMap = collectDataMap(chartDataDbMap, IndexChartEnum.CONTRACT);

        List<String> axisData = new ArrayList<>(recentDay);

        while (beginDay.isBefore(now)) {
            // 底部
            String formatDayStr = beginDay.format(DatePattern.NORM_DATE_FORMATTER);
            axisData.add(formatDayStr);
            // 默认值
            memberDataMap.putIfAbsent(formatDayStr, 0);
            enterpriseDataMap.putIfAbsent(formatDayStr, 0);
            labDataMap.putIfAbsent(formatDayStr, 0);
            dynamicDataMap.putIfAbsent(formatDayStr, 0);
            serverDataMap.putIfAbsent(formatDayStr, 0);
            contractDataMap.putIfAbsent(formatDayStr, 0);

            beginDay = beginDay.plusDays(1L);
        }

        LineChartSeries memberSeries =  LineChartSeries.getInstance(IndexChartEnum.MEMBER.getName(),new ArrayList<>(memberDataMap.values()));
        LineChartSeries enterpriseSeries =  LineChartSeries.getInstance(IndexChartEnum.ENTERPRISE.getName(),new ArrayList<>(enterpriseDataMap.values()));
        LineChartSeries labSeries =  LineChartSeries.getInstance(IndexChartEnum.LAB.getName(),new ArrayList<>(labDataMap.values()));
        LineChartSeries dynamicSeries =  LineChartSeries.getInstance(IndexChartEnum.DYNAMIC.getName(),new ArrayList<>(dynamicDataMap.values()));
        LineChartSeries serverSeries =  LineChartSeries.getInstance(IndexChartEnum.SERVER.getName(),new ArrayList<>(serverDataMap.values()));
        LineChartSeries contractSeries =  LineChartSeries.getInstance(IndexChartEnum.CONTRACT.getName(),new ArrayList<>(contractDataMap.values()));

        LineChartXRoteAxis axis = new LineChartXRoteAxis(axisData);

        IndexLineChart chart = IndexLineChart.builder()
                .xAxis(Arrays.asList(axis))
                .series(Arrays.asList(memberSeries,enterpriseSeries,labSeries,dynamicSeries,serverSeries,contractSeries))
                .build();

        chart.initLegend();

        return chart;
    }

    private Map<String,Integer> collectDataMap(Map<Integer, List<IndexChartDAO>> chartDataDbMap, IndexChartEnum chartEnum){
        List<IndexChartDAO> list = chartDataDbMap.get(chartEnum.getType());
        if(CollUtil.isEmpty(list)) {
            return new HashMap<>();
        }
        return list.stream().collect(Collectors.toMap(IndexChartDAO::getTime,IndexChartDAO::getCount,(oldV,newV) -> newV));
    }
}
