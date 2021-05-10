package com.qidao.qidao.equipment.equipment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEquipmentAddReq {

    private Long memberId;

    private String title;

    private String content;

    private String url;

    private Long maturity;

    private Integer type;

    private Long cooperation;

    private String thumb;

    private String video;

    private String imgs;

    private String labels;

    private Long salesmanId;

    private String articles;


}
