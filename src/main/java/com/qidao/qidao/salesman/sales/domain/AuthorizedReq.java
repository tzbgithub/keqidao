package com.qidao.qidao.salesman.sales.domain;

import lombok.Data;

@Data
public class AuthorizedReq {
    private Long id;
    private Long salesmanId;
    private Long memberId;
    private String authorizedImg;
    private Long authorizedSalesman;
}
