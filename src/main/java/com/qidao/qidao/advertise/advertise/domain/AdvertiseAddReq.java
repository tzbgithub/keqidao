package com.qidao.qidao.advertise.advertise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseAddReq {

    private String title;

    private Long location;

    private Long canal;

    private String linkUrl;

    private Integer sequence;

    private String img;

    private String beginTime;

    private String endTime;

    private String channelIds;

}
