package com.qidao.qidao.advertise.advertise.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 广告信息对象 advertise
 * 
 * @author autuan
 * @date 2021-02-23
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TAdvertise extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 广告结束时间 */
    @Excel(name = "广告结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;
    /** 广告开始时间 */
    @Excel(name = "广告开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;
    /** 广告状态 ： 0-启用 1-停用 */
    @Excel(name = "广告状态 ： 0-启用 1-停用")
    private Integer status;
    /** 广告跳转路径 */
    @Excel(name = "广告跳转路径")
    private String linkUrl;
    /** 广告图片 */
    @Excel(name = "广告图片")
    private String img;
    /** 排序值 越大越前 */
    @Excel(name = "排序值 越大越前")
    private Long sequence;
    /** 广告位置关联`select_config` */
    @Excel(name = "广告位置关联`select_config`")
    private Long location;
    /** 标题 */
    @Excel(name = "标题")
    private String title;
    /** 主键 */
    private Long id;
}
