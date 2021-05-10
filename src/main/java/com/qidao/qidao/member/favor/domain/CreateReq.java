package com.qidao.qidao.member.favor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReq {

    /**
     * 收藏动态用户ID
     */
    private Long memberId;

    /**
     * 动态ID
     */
    private Long dynamicId;


}
