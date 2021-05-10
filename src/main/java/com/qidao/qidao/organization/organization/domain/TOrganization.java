package com.qidao.qidao.organization.organization.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 组织机构对象 organization
 * 
 * @author autuan
 * @date 2020-12-17
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TOrganization extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 审核原因 */
    @Excel(name = "审核原因")
    private String verifyReason;
    /** 0-未审核 1-审核中 2-审核后    入驻审核 */
    @Excel(name = "0-未审核 1-审核中 2-审核后    入驻审核")
    private Long verifyStatus;
    /** vip结束时间 */
    @Excel(name = "vip结束时间")
    private Date vipEndTime;
    /** vip开始时间 */
    @Excel(name = "vip开始时间")
    private Date vipStartTime;
    /** 0-未认证 1-认证中 2-已认证    企业认证 */
    @Excel(name = "0-未认证 1-认证中 2-已认证    企业认证")
    private Long status;
    /** 技术规模id 关联select_config */
    @Excel(name = "技术规模id 关联select_config")
    private Long techScaleId;
    /** 详细地址 */
    @Excel(name = "详细地址")
    private String addressDetail;
    /** 地址区名称 */
    @Excel(name = "地址区名称")
    private String addressAreaName;
    /** 地址区ID */
    @Excel(name = "地址区ID")
    private Long addressAreaId;
    /** 地址市名称 */
    @Excel(name = "地址市名称")
    private String addressCityName;
    /** 地址市id */
    @Excel(name = "地址市id")
    private Long addressCityId;
    /** 地址省名称 */
    @Excel(name = "地址省名称")
    private String addressProvinceName;
    /** 地址省ID */
    @Excel(name = "地址省ID")
    private Long addressProvinceId;
    /** 证书/导师 资格证图片 */
    @Excel(name = "证书/导师 资格证图片")
    private String qualifications;
    /** 执照/铭牌 路径 */
    @Excel(name = "执照/铭牌 路径")
    private String license;
    /** 注册时间 */
    @Excel(name = "注册时间")
    private Date signTime;
    /** 规模id 关联select_config */
    @Excel(name = "规模id 关联select_config")
    private Long scaleId;
    /** 经费id 关联select_config */
    @Excel(name = "经费id 关联select_config")
    private String fundsId;
    /** 所属行业备注 */
    @Excel(name = "所属行业备注")
    private String industryRemark;
    /** 所属行业id 关联select_config */
    @Excel(name = "所属行业id 关联select_config")
    private Long industryId;
    /** 简介 */
    @Excel(name = "简介")
    private String summary;
    /** 名称 */
    @Excel(name = "名称")
    private String name;
    /** 空间背景图 */
    @Excel(name = "空间背景图")
    private String backendImage;
    /** 负责人用户ID */
    @Excel(name = "负责人用户ID")
    private Long responsibleMemberId;
    /** 类别：0-实验室；1-公司 */
    @Excel(name = "类别：0-实验室；1-公司")
    private Long type;
    /** 主键 */
    private String id;
    private String belong;

}
