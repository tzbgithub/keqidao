package com.qidao.qidao.organization.verify.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyListRes {

    private Long id;

    private String name;

    private Integer type;

    private String signTime;

    private String memberName;

    private String updateTime;

    private String verifyName;

    private String recheckName;

    private String verifyTime;

    private String maintainer;

    private Integer verifyStatus;

}
