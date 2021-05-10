package com.qidao.qidao.link.linkLabel.service;


import com.qidao.qidao.link.linkLabel.domain.TLinkLabel;

import java.util.List;

/**
 * 标签中间Service接口
 *
 * @author autuan
 * @date 2020-12-28
 */
public interface TLinkLabelService {
    /**
     * 查询标签中间
     *
     * @param id 标签中间ID
     * @return 标签中间
     */
    TLinkLabel selectLinkLabelById(Long id);

    /**
     * 查询标签中间列表
     *
     * @param TLinkLabel 标签中间
     * @return 标签中间集合
     */
    List<TLinkLabel> selectLinkLabelList(TLinkLabel TLinkLabel);

    /**
     * 新增标签中间
     *
     * @param TLinkLabel 标签中间
     * @return 结果
     */
    int insertLinkLabel(TLinkLabel TLinkLabel);

    /**
     * 修改标签中间
     *
     * @param TLinkLabel 标签中间
     * @return 结果
     */
    int updateLinkLabel(TLinkLabel TLinkLabel);

    /**
     * 批量删除标签中间
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLinkLabelByIds(String ids);

    /**
     * 删除标签中间信息
     *
     * @param id 标签中间ID
     * @return 结果
     */
    int deleteLinkLabelById(Long id);

    int logicDelByIds(String ids);
}
