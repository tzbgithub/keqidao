package com.qidao.qidao.msg.msg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgAddReq {

    private Long menuId;

    private String title;

    private Integer type;

    private String expireTime;

    private String pushTime;

    private Integer sequence;

    private Integer receiveType;

    private Integer maxNum;

    private Long memberId;

    private Integer contentType;

    private Integer titleType;

    private String content;
}
