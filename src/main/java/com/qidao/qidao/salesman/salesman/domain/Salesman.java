package com.qidao.qidao.salesman.salesman.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 销售员对象 salesman
 *
 * @author autuan
 * @date 2020-12-31
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salesman extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 小程序唯一标识 */
    @Excel(name = "小程序唯一标识")
    private String unionId;
    /** 头像 */
    @Excel(name = "头像")
    private String headImage;
    /** 密码 */
    @Excel(name = "密码")
    private String password;
    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;
    /** 名称 */
    @Excel(name = "名称")
    private String name;
    /** 账户 */
    @Excel(name = "账户")
    private String no;
    /** 主键 */
    private Long id;
}
