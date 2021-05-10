package com.qidao.qidao.member.subscribe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeToEdit {

    private Long id;

    private Long memberId;

    private String memberName;

    private Long SubscribeId;

    private String SubscribeName;

    private Integer type;

    private Integer SubscribeType;

}
