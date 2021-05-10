package com.qidao.qidao.member.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAddVipReq {

    private Long id;

    private String vipStartTime;

    private String vipEndTime;

    private Integer type;

}