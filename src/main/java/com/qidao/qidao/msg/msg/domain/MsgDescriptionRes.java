package com.qidao.qidao.msg.msg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgDescriptionRes {

    private Long id;

    private String menuId;

    private String title;

    private Integer type;

    private Integer status;

    private String expireTime;

    private String pushTime;

    private Integer sequence;

    private Integer receiveType;

    private Integer maxNum;

    private Integer contentType;

    private Integer titleType;

    private String content;

}
