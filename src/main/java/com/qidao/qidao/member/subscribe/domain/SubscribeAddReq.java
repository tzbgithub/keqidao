package com.qidao.qidao.member.subscribe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeAddReq {

    private Long memberId;

    private Long subscribeId;

    private Integer type;

    private Integer subscribeType;

}
