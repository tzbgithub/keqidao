package com.qidao.qidao.member.memberLabel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberLabelListReq {

    private String name;

    private String startTime;

    private String endTime;

}
