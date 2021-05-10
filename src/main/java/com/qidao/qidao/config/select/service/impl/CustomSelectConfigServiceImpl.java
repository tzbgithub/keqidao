package com.qidao.qidao.config.select.service.impl;

import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.config.dict.domain.Dict;
import com.qidao.qidao.config.dict.mapper.DictMapper;
import com.qidao.qidao.config.select.domain.CustomSelectConfig;
import com.qidao.qidao.config.select.domain.HotIndustryReq;
import com.qidao.qidao.config.select.domain.SelectConfig;
import com.qidao.qidao.config.select.mapper.CustomSelectConfigMapper;
import com.qidao.qidao.config.select.mapper.SelectConfigMapper;
import com.qidao.qidao.config.select.service.CustomSelectConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("customSelectConfigService")
public class CustomSelectConfigServiceImpl implements CustomSelectConfigService {

    @Resource
    private CustomSelectConfigMapper customSelectConfigMapper;

    @Resource
    private SelectConfigMapper selectConfigMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private DictMapper dictMapper;

    @Override
    public List<CustomSelectConfig> getAllFather(Integer type) {
        if (type == null){
            List<CustomSelectConfig> selectConfigs = new ArrayList<>();
            CustomSelectConfig selectConfig = new CustomSelectConfig();
            selectConfig.setVal("请先选择类型(非必填)");
            selectConfigs.add(selectConfig);
            return selectConfigs;
        }
        return customSelectConfigMapper.getAllFather(type);
    }

    @Override
    public int create(CustomSelectConfig selectConfig) {
        selectConfig.setId(snowflakeIdWorker53.nextId());
        selectConfig.setDelFlag(0);
        if (selectConfig.getPid() == null){
            selectConfig.setPid(0L);
        }
        selectConfig.setStatus(0);
        return customSelectConfigMapper.create(selectConfig);
    }

    @Override
    public int updateStatus(Long id) {
        SelectConfig selectConfig = selectConfigMapper.selectSelectConfigById(String.valueOf(id));
        Long status = selectConfig.getStatus();
        if (status == 1L){
            return customSelectConfigMapper.updateStatus(id , 0);
        }
        return customSelectConfigMapper.updateStatus(id , 1);
    }

    @Override
    public List<CustomSelectConfig> getConfigByType(Integer type) {
        return customSelectConfigMapper.getConfigByType(type);
    }

    @Override
    public List<Dict> findDict() {
        return dictMapper.selectByExample(null);
    }

    @Override
    public List<CustomSelectConfig> getHotIndustry(HotIndustryReq req) {
        return customSelectConfigMapper.getHotIndustry(req.getVal() , req.getPid() , req.getStatus());
    }

    @Override
    public int hot(Long id) {
        return customSelectConfigMapper.hot(id);
    }

    @Override
    public int notHot(Long id) {
        return customSelectConfigMapper.notHot(id);
    }
}
