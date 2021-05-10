package com.qidao.qidao.organization.organization.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationUpdateReq {

    /**
     * 简介
     */
    private String summary;

    /**
     * 规模
     */
    private Long scaleId;

    /**
     * ID
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 研究经费
     */
    private String fundsId;

    /**
     * 所属单位
     */
    private String belong;

    private String oldBelong;

    private String oldName;

    /**
     * 负责人ID
     */
    private Long responsibleMemberId;

    /**
     * 地址省编码
     */
    private Long addressProvinceId;

    /**
     * 地址省名字
     */
    private String addressProvinceName;

    /**
     * 地址市编码
     */
    private Long addressCityId;

    /**
     * 地址市名字
     */
    private String addressCityName;

    /**
     * 地址区编码
     */
    private Long addressAreaId;

    /**
     * 地址区名字
     */
    private String addressAreaName;

    private Integer type;

}
