package com.qidao.qidao.dynamic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicDetails {

    private Long id;

    private String title;

    private String url;

    private List<String> img;

    private String thumb;

    private String video;

    private String publishTime;

    private String memberName;

    private Integer verifyStatus;

    private String content;

    private Long channelId;

}
