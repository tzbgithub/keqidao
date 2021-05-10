package com.qidao.qidao.salesman.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-02-04 15:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesQuery {
    private String salesmanId;
}
