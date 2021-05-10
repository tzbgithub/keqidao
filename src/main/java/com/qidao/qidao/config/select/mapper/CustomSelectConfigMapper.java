package com.qidao.qidao.config.select.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.config.select.domain.CustomSelectConfig;
import com.qidao.qidao.config.select.domain.HotIndustryReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomSelectConfigMapper {

    List<CustomSelectConfig> getAllFather(Integer type);

    int create(CustomSelectConfig selectConfig);

    int updateStatus(Long id , Integer status);

    List<CustomSelectConfig> getConfigByType(Integer type);

    Page<CustomSelectConfig> getHotIndustry(String val , Long pid , Integer status);

    int hot(Long id);

    int notHot(Long id);
}
