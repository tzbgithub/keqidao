package com.qidao.qidao.member.memberLabel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberLabelListRes {

    private Long memberId;

    private String label;

    private Long labelId;

    private String memberName;

    private String phone;

    private String industry;

    private String belong;

    private String createTime;

    private String dynamic;

    private String server;

}
