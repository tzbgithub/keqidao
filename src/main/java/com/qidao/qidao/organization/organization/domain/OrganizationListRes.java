package com.qidao.qidao.organization.organization.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
public class OrganizationListRes{

    /**
     * 主键
     */
    private String id;

    /**
     * 所属单位
     */
    private String belong;

    /**
     * 实验室名称
     */
    private String name;

    /**
     * 简介
     */
    private String summary;

    /**
     * 负责人名称
     */
    private String responsibleMemberName;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 地址区名称
     */
    private String addressAreaName;

    /**
     * 地址市名称
     */
    private String addressCityName;

    /**
     * 地址省名称
     */
    private String addressProvinceName;

    /**
     * 注册时间
     */
    private LocalDateTime signTime;

    /**
     * 所属行业
     */
    private String industryRemark;

    private String industry;

    /**
     * 会员开始时间
     */
    private LocalDateTime vipStartTime;

    /**
     * 会员结束时间
     */
    private LocalDateTime vipEndTime;

    /**
     * 认证状态
     */
    private Integer status;

    //private Integer verifyStatus;

}
