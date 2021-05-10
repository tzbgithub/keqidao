package com.qidao.qidao.equipment.equipment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEquipmentPageReq {

    private String startTime;

    private String endTime;

    private String title;

    private String organization;

    private Integer type;

    private Integer verifyStatus;

}
