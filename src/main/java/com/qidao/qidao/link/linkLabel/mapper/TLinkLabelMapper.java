package com.qidao.qidao.link.linkLabel.mapper;


import com.qidao.qidao.link.linkLabel.domain.TLinkLabel;

import java.util.List;

/**
 * 标签中间Mapper接口
 *
 * @author autuan
 * @date 2020-12-28
 */
public interface TLinkLabelMapper {
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
     * 删除标签中间
     *
     * @param id 标签中间ID
     * @return 结果
     */
    int deleteLinkLabelById(Long id);

    /**
     * 批量删除标签中间
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLinkLabelByIds(String[] ids);

    int logicDelByIds(String[] ids);
}
