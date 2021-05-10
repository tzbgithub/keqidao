package com.qidao.qidao.member.favor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavorPageReq {

    private String beginTime;

    private String endTime;

    private String dynamicTitle;

    private String dynamicPushMemberName;

    private String memberName;

}
