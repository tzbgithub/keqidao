package com.qidao.qidao.member.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetails {

    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 学历
     */
    private String education;

    /**
     * 实验室名称
     */
    private String organization;

    /**
     * 行业
     */
    private String industry;

    /**
     * 单位
     */
    private String belong;

    /**
     * 职位
     */
    private String position;

    /**
     * 科研方向
     */
    private String labels;

    /**
     * 可提供的服务
     */
    private String dict;

    /**
     * 规模
     */
    private String scale;

    /**
     * 服务技术规模
     */
    private String techScale;

    /**
     * 地址
     */
    private String address;

    /**
     * 头像
     */
    private String headImg;

    private String qualifications;

    private String license;

    private Integer verifyStatus;

    private String msg;

}
