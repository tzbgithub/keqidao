package com.qidao.qidao.member.subscribe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeUpdateReq {

    private Long id;

    private Long memberId;

    private Long subscribeId;

    private Long oldSubscribeId;

    private Integer type;

}
