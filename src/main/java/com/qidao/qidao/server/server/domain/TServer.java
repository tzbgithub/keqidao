package com.qidao.qidao.server.server.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 服务(需求)对象 server
 * 
 * @author yqj
 * @date 2021-02-18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TServer extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 期望解决时间 */
    @Excel(name = "期望解决时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date solutionTime;
    /** 图片或视频地址 */
    @Excel(name = "图片或视频地址")
    private String url;
    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumb;
    /** 需求描述 */
    @Excel(name = "需求描述")
    private String description;
    /** 研究经费id 关联select_config */
    @Excel(name = "研究经费id 关联select_config")
    private Long specAmountId;
    /** 需求领域id 关联select_config */
    @Excel(name = "需求领域id 关联select_config")
    private Long specAreaId;
    /** 地址区名称 */
    @Excel(name = "地址区名称")
    private String addressAreaName;
    /** 地址区ID */
    @Excel(name = "地址区ID")
    private Integer addressAreaId;
    /** 地址市名称 */
    @Excel(name = "地址市名称")
    private String addressCityName;
    /** 地址市id */
    @Excel(name = "地址市id")
    private Integer addressCityId;
    /** 地址省名称 */
    @Excel(name = "地址省名称")
    private String addressProvinceName;
    /** 地址省ID */
    @Excel(name = "地址省ID")
    private Integer addressProvinceId;
    /** 标题名称 */
    @Excel(name = "标题名称")
    private String title;
    /** 状态类别：0-草稿；1-已发布；2-已接受；3-已取消 */
    @Excel(name = "状态类别：0-草稿；1-已发布；2-已接受；3-已取消")
    private Integer status;
    /** null */
    @Excel(name = "null")
    private Long memberIdPartyB;
    /** 甲方（发布者）用户ID */
    @Excel(name = "甲方", readConverterExp = "发=布者")
    private Long memberIdPartyA;
    /** null */
    @Excel(name = "null")
    private Long organizedIdPartyB;
    /** 甲方（发布方）组织ID */
    @Excel(name = "甲方", readConverterExp = "发=布方")
    private Long organizedIdPartyA;
    /** 主键 */
    private Long id;
}
