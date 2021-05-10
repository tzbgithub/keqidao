package com.qidao.qidao.organization.organization.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationAddReq {

    /**
     * 类型 0-实验室 1-公司/企业
     */
    private Integer type;

    /**
     * 实验室名称
     */
    private String name;

    /**
     * 所属单位
     */
    private String belong;

    /**
     * 所属行业标识
     */
    private Long industry;

    /**
     * 备注
     */
    private String industryRemark;

    /**
     * 实验室简介
     */
    private String summary;

    /**
     * 科研人员姓名
     */
    private String memberName;

    /**
     * 科研人员科研方向
     */
    private String labels;

    /**
     * 科研人员学历
     */
    private Long education;

    /**
     * 科研人员职称
     */
    private Long position;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 实验室规模
     */
    private Long scale;

    /**
     * 省编码
     */
    private String province;

    /**
     * 省
     */
    private String provinceCode;

    /**
     * 市编码
     */
    private String city;

    /**
     * 市
     */
    private String cityCode;

    /**
     * 区编码
     */
    private String area;

    /**
     * 区
     */
    private String areaCode;

    /**
     * 服务技术规模
     */
    private Long techScale;


    //private String server;

    /**
     * 执照/铭牌
     */
    private String license;


    //private String fundsId;

    private String qualifications;

}
