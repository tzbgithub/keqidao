package com.qidao.qidao.dynamic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyReq {

    private Long channel;

    private Long id;

    private Long oldChannel;

}