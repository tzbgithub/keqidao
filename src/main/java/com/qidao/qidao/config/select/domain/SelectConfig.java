package com.qidao.qidao.config.select.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 选择配置对象 select_config
 * 
 * @author autuan
 * @date 2020-12-16
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectConfig extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 状态 0-正常 1-停用 */
    @Excel(name = "状态 0-正常 1-停用")
    private Long status;
    /** 排序值 越大越前 */
    @Excel(name = "排序值 越大越前")
    private Long sequence;
    /** 展示值 */
    @Excel(name = "展示值")
    private String val;
    /** 0-服务需求领域;1-组织规模大小;2-研发规模大小;3-研发经费;4-学历;5-职位;6-行业;7-投诉;8-反馈；9-会员领域 */
    @Excel(name = "0-服务需求领域;1-组织规模大小;2-研发规模大小;3-研发经费;4-学历;5-职位;6-行业;7-投诉;8-反馈；9-会员领域")
    private Long type;
    /** 主键 */
    private String id;

    private String typeName;
}
