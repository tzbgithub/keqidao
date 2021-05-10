package com.qidao.qidao.organization.verify.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyListReq {

    private String name;

    private Integer type;

    private String startTime;

    private String endTime;

    private Integer status;

}
