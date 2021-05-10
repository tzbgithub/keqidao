package com.qidao.qidao.member.subscribe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySubscribeMemberReq {

    private Long id;

    private String name;

}
