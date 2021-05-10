package com.qidao.qidao.config.other.mapper;

import com.qidao.qidao.config.other.domain.IndexChartDAO;
import com.qidao.qidao.config.other.domain.IndexCountRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface CustomOtherMapper {
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
     * @return 统计数据
     */
    List<IndexChartDAO> queryLineChart(@Param("recentDay") Integer recentDay);
}
