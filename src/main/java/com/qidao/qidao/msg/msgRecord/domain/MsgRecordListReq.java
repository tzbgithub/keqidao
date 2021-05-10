package com.qidao.qidao.msg.msgRecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgRecordListReq {

    private String msgTitle;

    private Integer status;

    private String memberName;

    private String startTime;

    private String endTime;

}
