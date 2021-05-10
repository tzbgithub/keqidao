package com.qidao.qidao.order.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderListReq {

    private String memberName;

    private Integer status;

    private String startTime;

    private String endTime;

}
