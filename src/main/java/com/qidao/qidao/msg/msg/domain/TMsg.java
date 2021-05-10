package com.qidao.qidao.msg.msg.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 消息对象 msg
 * 
 * @author yqj
 * @date 2021-02-19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TMsg extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 标题类型 0-原文发送 1-验证码 */
    @Excel(name = "标题类型 0-原文发送 1-验证码")
    private Integer titleType;
    /** 内容类型  0-原文发送 1-验证码 */
    @Excel(name = "内容类型  0-原文发送 1-验证码")
    private Integer contentType;
    /** 用户最大可接收同一消息条数：0：不限制 */
    @Excel(name = "用户最大可接收同一消息条数：0：不限制")
    private Integer maxNum;
    /** 接收类型 0-全平台发送 1-指定用户发送 */
    @Excel(name = "接收类型 0-全平台发送 1-指定用户发送")
    private Integer receiveType;
    /** 排序值 越大越前 */
    @Excel(name = "排序值 越大越前")
    private Integer sequence;
    /** 推送时间 */
    @Excel(name = "推送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pushTime;
    /** 过期时间 */
    @Excel(name = "过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireTime;
    /** 0-未发送 1-已发送 2-发送失败 -1:无需此字段 */
    @Excel(name = "0-未发送 1-已发送 2-发送失败 -1:无需此字段")
    private Integer status;
    /** 消息类型  0-不推送 1-立即推送 2-每日推送 3-定时发送 4-触发类型：用户注册 5-滚动消息：达成合作 6-用户获取短信验证码 */
    @Excel(name = "消息类型  0-不推送 1-立即推送 2-每日推送 3-定时发送 4-触发类型：用户注册 5-滚动消息：达成合作 6-用户获取短信验证码")
    private Integer type;
    /** 内容 */
    @Excel(name = "内容")
    private String content;
    /** 标题 */
    @Excel(name = "标题")
    private String title;
    /** 菜单类型ID */
    @Excel(name = "菜单类型ID")
    private Long menuId;
    /** 主键 */
    private Long id;
}
