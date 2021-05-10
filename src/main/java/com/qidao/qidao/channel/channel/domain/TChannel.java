package com.qidao.qidao.channel.channel.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 频道对象 channel
 * 
 * @author yqj
 * @date 2021-02-03
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TChannel extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 排序值(越大越前) */
    @Excel(name = "排序值(越大越前)")
    private Integer sequence;
    /** 频道标题(频道名) */
    @Excel(name = "频道标题(频道名)")
    private String title;
    /** 主键 */
    private Long id;
}
