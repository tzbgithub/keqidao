package com.qidao.qidao.salesman.sales.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 销售关联组织机构对象 link_organization_salesman
 * 
 * @author autuan
 * @date 2021-03-09
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkOrganizationSalesman extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private String dynamicNum;

    private String equipmentNum;
    /** 被授权 运营人员 */
    @Excel(name = "被授权 运营人员")
    private Long authorizedSalesman;
    /** 授权扫描图 */
    @Excel(name = "授权扫描图")
    private String authorizedImg;
    /** 是否授权 代发布内容 0-否 1-是 */
    @Excel(name = "是否授权 代发布内容 0-否 1-是")
    private Long authoorized;
    /** 入驻会员名(冗余) */
    @Excel(name = "入驻会员名(冗余)")
    private String memberName;
    /** 入驻会员ID */
    @Excel(name = "入驻会员ID")
    private Long memberId;
    /** 组织机构名称 */
    @Excel(name = "组织机构名称")
    private String organizationName;
    /** 关联类型 (0-无实验室新增 1-已有此实验室) */
    @Excel(name = "关联类型 (0-无实验室新增 1-已有此实验室)")
    private Integer type;
    /** 销售员名字 */
    @Excel(name = "销售员名字")
    private String salesmanName;
    /** 销售员标识 */
    @Excel(name = "销售员标识")
    private Long salesmanId;
    /** 组织机构标识 */
    @Excel(name = "组织机构标识")
    private Long organizationId;
    /** 主键 */
    private Long id;
}
