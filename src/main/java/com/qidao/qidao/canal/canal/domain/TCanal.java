package com.qidao.qidao.canal.canal.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 各包分发渠道对象 canal
 * 
 * @author yqj
 * @date 2021-02-18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TCanal extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 包下载路径 */
    @Excel(name = "包下载路径")
    private String downPath;
    /** 当前版本号 */
    @Excel(name = "当前版本号")
    private String version;
    /** 渠道名称 */
    @Excel(name = "渠道名称")
    private String name;
    /** 主键 */
    private Long id;
}
