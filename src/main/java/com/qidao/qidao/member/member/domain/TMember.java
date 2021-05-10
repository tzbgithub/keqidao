package com.qidao.qidao.member.member.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户对象 member
 * 
 * @author autuan
 * @date 2020-12-16
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TMember extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** null */
    @Excel(name = "null")
    private String email;
    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String name;
    /** 行业id 关联select_config */
    @Excel(name = "行业id 关联select_config")
    private Long industryId;
    /** vip结束时间 */
    @Excel(name = "vip结束时间")
    private Date vipEndTime;
    /** vip开始时间 */
    @Excel(name = "vip开始时间")
    private Date vipStartTime;
    /** 个人空间背景图 */
    @Excel(name = "个人空间背景图")
    private String backendImage;
    /** 头像 */
    @Excel(name = "头像")
    private String headImage;
    /** 密码 */
    @Excel(name = "密码")
    private String password;
    /** 所属单位 */
    @Excel(name = "所属单位")
    private String belong;
    /** 推送开关 0-关 1-开 */
    @Excel(name = "推送开关 0-关 1-开")
    private Long pushStatus;
    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;
    /** 学历id 关联select_config */
    @Excel(name = "学历id 关联select_config")
    private Long educationId;
    /** 职位id 关联select_config */
    @Excel(name = "职位id 关联select_config")
    private Long positionId;
    /** 角色：0-普通用户；1-主管；2-管理员 */
    @Excel(name = "角色：0-普通用户；1-主管；2-管理员")
    private Long role;
    /** 组织id */
    @Excel(name = "组织id")
    private Long organizationId;
    /** 会员等级：0-普通会员；1-vip会员 */
    @Excel(name = "会员等级：0-普通会员；1-vip会员")
    private Long level;
    /** 编号 */
    @Excel(name = "编号")
    private String no;
    /** 主键 */
    private String id;
}
