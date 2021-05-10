package com.qidao.qidao.product.product.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * 产品对象 product_sku
 * 
 * @author yqj
 * @date 2021-02-01
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TProduct extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 库存 */
    @Excel(name = "库存")
    private Long stock;
    /** 0-都可购买 1-只限实验室下属导师购买 2-只限企业机构购买 */
    @Excel(name = "0-都可购买 1-只限实验室下属导师购买 2-只限企业机构购买")
    private Long permission;
    /** type=0 存放本产品的服务时间(单位：分)；type=1 o */
    @Excel(name = "type=0 存放本产品的服务时间(单位：分)；type=1 o")
    private Long serverVal;
    /** 计费方式：0-时间；1-次数 */
    @Excel(name = "计费方式：0-时间；1-次数")
    private Long type;
    /** 市场价 */
    @Excel(name = "市场价")
    private Double marketPrice;
    /** 销售价 */
    @Excel(name = "销售价")
    private Double salePrice;
    /** 产品图片 */
    @Excel(name = "产品图片")
    private String imgs;
    /** 产品简介 */
    @Excel(name = "产品简介")
    private String summary;
    /** 产品名 */
    @Excel(name = "产品名")
    private String name;
    /** 主键 */
    private Long id;

    private Integer sequence;

    private String url;

    private String extra;

    private List<String> extras;
}
