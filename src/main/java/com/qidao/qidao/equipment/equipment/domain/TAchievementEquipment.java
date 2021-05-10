package com.qidao.qidao.equipment.equipment.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 设备/成果对象 achievement_equipment
 * 
 * @author autuan
 * @date 2021-02-04
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TAchievementEquipment extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 审核客服ID */
    @Excel(name = "审核客服ID")
    private Long verifyUserId;
    /** 审核原因 */
    @Excel(name = "审核原因")
    private String verifyReason;
    /** 审核状态:0-待审核 1-审核通过 2-审核拒绝 */
    @Excel(name = "审核状态:0-待审核 1-审核通过 2-审核拒绝")
    private Integer verifyStatus;
    /** 内容 */
    @Excel(name = "内容")
    private String content;
    /** 简介 */
    @Excel(name = "简介")
    private String summary;
    /** 图片，以`,`(英文逗号)分割 */
    @Excel(name = "图片，以`,`(英文逗号)分割")
    private String imgs;
    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumb;
    /** 视频 */
    @Excel(name = "视频")
    private String video;
    /** 标题 */
    @Excel(name = "标题")
    private String title;
    /** 成熟度 */
    @Excel(name = "成熟度")
    private Integer maturity;
    /** 类别：0-专利 1-设施设备 2-项目经历 3-获奖 4-专著论文 5-科研基金 */
    @Excel(name = "类别：0-专利 1-设施设备 2-项目经历 3-获奖 4-专著论文 5-科研基金")
    private Integer type;
    /** 组织机构ID(实验室、企业等) */
    @Excel(name = "组织机构ID(实验室、企业等)")
    private Long organizationId;
    /** 链接 */
    @Excel(name = "链接")
    private String url;
    /** 主键 */
    private Long id;
}
