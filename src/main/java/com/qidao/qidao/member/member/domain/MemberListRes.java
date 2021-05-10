package com.qidao.qidao.member.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberListRes {

    private Long id;

    private String name;

    private String phone;

    private Integer type;

    private String createTime;

    private Integer level;

    private Integer verifyStatus;

    private String startTime;

    private String endTime;

    private BigDecimal price;

}
