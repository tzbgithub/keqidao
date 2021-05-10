package com.qidao.qidao.msg.msgMenu.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 消息菜单类型对象 msg_menu
 * 
 * @author yqj
 * @date 2021-02-19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TMsgMenu extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 0-正常使用 1-关闭 */
    @Excel(name = "0-正常使用 1-关闭")
    private Integer status;
    /** 封面图 */
    @Excel(name = "封面图")
    private String thumb;
    /** null */
    @Excel(name = "null")
    private String name;
    /** 父ID */
    @Excel(name = "父ID")
    private Long pid;
    /** 主键 */
    private Long id;
}
