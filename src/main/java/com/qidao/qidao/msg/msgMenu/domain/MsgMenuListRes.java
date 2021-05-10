package com.qidao.qidao.msg.msgMenu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgMenuListRes {

    private Long id;

    private String name;

    private String fatherName;

    private String createTime;

    private String createBy;

    private Long createById;

    private String thumb;

    private Integer status;

}
