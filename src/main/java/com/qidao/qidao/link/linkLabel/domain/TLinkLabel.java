package com.qidao.qidao.link.linkLabel.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 标签中间对象 link_label
 * 
 * @author autuan
 * @date 2020-12-28
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TLinkLabel extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 关联对象的主键ID（eg：动态ID、用户ID等） */
    @Excel(name = "关联对象的主键ID", readConverterExp = "e=g：动态ID、用户ID等")
    private Long sourceId;
    /** 标签类别：0-动态；1-服务；2-频道；3-用户；4-组织机构;5-设施设备;6-成果 */
    @Excel(name = "标签类别：0-动态；1-服务；2-频道；3-用户；4-组织机构;5-设施设备;6-成果")
    private Long type;
    /** 标签ID */
    @Excel(name = "标签ID")
    private Long labelId;
    /** 主键 */
    private Long id;
}
