package com.qidao.qidao.equipment.equipment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEquipmentDescription {

    private Long id;

    private Integer type;

    private String title;

    private String organizationName;

    private String createTime;

    private Integer verifyStatus;

    private String maturity;

    private String url;

    private String video;

    private String imgs;

    private List<String> imgList;

    private String summary;

    private String content;

    private String thumb;

    private String cooperation;

    private String articles;
    private String labels;
}
