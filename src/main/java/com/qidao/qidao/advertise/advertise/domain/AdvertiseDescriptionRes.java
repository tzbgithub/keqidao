package com.qidao.qidao.advertise.advertise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseDescriptionRes {

    private Long id;

    private String title;

    private String location;

    private String img;

    private String linkUrl;

    private String canal;

    private Integer status;

    private String beginTime;

    private String endTime;

    private Long createById;

    private String createByName;

    private String createTime;

    private Long canalId;

    private Long locationId;

    private Integer sequence;

    private String channel;

}
