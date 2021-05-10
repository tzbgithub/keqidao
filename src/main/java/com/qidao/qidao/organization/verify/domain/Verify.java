package com.qidao.qidao.organization.verify.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Verify {

    private Long id;

    private String name;

    private Integer type;

    private String signTime;

    private String memberName;

    private String updateTime;

    private Long verifyId;

    private Long recheckId;

    private String verifyTime;

    private String maintainer;

    private Integer verifyStatus;

}
