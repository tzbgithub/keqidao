package com.qidao.qidao.config.select.service;

import com.qidao.qidao.config.dict.domain.Dict;
import com.qidao.qidao.config.select.domain.CustomSelectConfig;
import com.qidao.qidao.config.select.domain.HotIndustryReq;

import java.util.List;

public interface CustomSelectConfigService {

    List<CustomSelectConfig> getAllFather(Integer type);

    int create(CustomSelectConfig selectConfig);

    int updateStatus(Long id );

    List<CustomSelectConfig> getConfigByType(Integer type);

    List<Dict> findDict();

    List<CustomSelectConfig> getHotIndustry(HotIndustryReq req);

    int hot(Long id);

    int notHot(Long id);
}
