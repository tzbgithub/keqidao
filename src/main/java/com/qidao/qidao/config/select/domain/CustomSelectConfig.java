package com.qidao.qidao.config.select.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomSelectConfig {

    private Long id;
    private Long pid;
    private Integer type;
    private String val;
    private Integer sequence;
    private Integer status;
    private Integer delFlag;
    private Integer hot;

}
