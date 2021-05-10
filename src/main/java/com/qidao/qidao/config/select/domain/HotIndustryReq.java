package com.qidao.qidao.config.select.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotIndustryReq {

    private String val;

    private Long pid;

    private Integer status;

}
