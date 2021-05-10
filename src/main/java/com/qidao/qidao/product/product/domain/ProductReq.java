package com.qidao.qidao.product.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReq {

    /**
     * 产品名
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 购买权限
     */
    private Integer permission;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
