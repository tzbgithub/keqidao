package com.qidao.qidao.link.linkLabel.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;

import com.qidao.qidao.link.linkLabel.domain.TLinkLabel;
import com.qidao.qidao.link.linkLabel.mapper.TLinkLabelMapper;
import com.qidao.qidao.link.linkLabel.service.TLinkLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 标签中间Service业务层处理
 *
 * @author autuan
 * @date 2020-12-28
 */
@Service
public class TLinkLabelServiceImpl implements TLinkLabelService {
    @Autowired
    private TLinkLabelMapper TLinkLabelMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询标签中间
     *
     * @param id 标签中间ID
     * @return 标签中间
     */
    @Override
    public TLinkLabel selectLinkLabelById(Long id) {
        return TLinkLabelMapper.selectLinkLabelById(id);
    }

    /**
     * 查询标签中间列表
     *
     * @param TLinkLabel 标签中间
     * @return 标签中间
     */
    @Override
    public List<TLinkLabel> selectLinkLabelList(TLinkLabel TLinkLabel) {
        return TLinkLabelMapper.selectLinkLabelList(TLinkLabel);
    }

    /**
     * 新增标签中间
     *
     * @param TLinkLabel 标签中间
     * @return 结果
     */
    @Override
    public int insertLinkLabel(TLinkLabel TLinkLabel) {
        TLinkLabel.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        TLinkLabel.setId(snowflakeIdWorker.nextId());
        return TLinkLabelMapper.insertLinkLabel(TLinkLabel);
    }

    /**
     * 修改标签中间
     *
     * @param TLinkLabel 标签中间
     * @return 结果
     */
    @Override
    public int updateLinkLabel(TLinkLabel TLinkLabel) {


        TLinkLabel.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return TLinkLabelMapper.updateLinkLabel(TLinkLabel);
    }

    /**
     * 删除标签中间对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLinkLabelByIds(String ids) {
        return TLinkLabelMapper.deleteLinkLabelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除标签中间信息
     *
     * @param id 标签中间ID
     * @return 结果
     */
    @Override
    public int deleteLinkLabelById(Long id) {
        return TLinkLabelMapper.deleteLinkLabelById(id);
    }


    /**
     * 逻辑删除标签中间对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return TLinkLabelMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
