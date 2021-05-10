package com.qidao.qidao.member.subscribe.domain;

import com.qidao.framework.aspectj.lang.annotation.Log;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchSubscribeMemberReq {

    private Long id;

    private String code;

}
