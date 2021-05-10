package com.qidao.qidao.advertise.advertise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseListReq {

    private Long location;

    private String title;

    private Integer status;

    private Long canal;

    private String startTime;

    private String endTime;

}
