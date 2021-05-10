package com.qidao.qidao.member.memberLabel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLabelDescriptionRes {

    private Long memberId;

    private String label;

    private String memberName;

    private String phone;

    private String industry;

    private String belong;

    private String createTime;

    private String dynamic;

    private String server;

    private Integer type;

}
