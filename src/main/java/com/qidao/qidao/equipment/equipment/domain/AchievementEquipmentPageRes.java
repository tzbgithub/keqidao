package com.qidao.qidao.equipment.equipment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEquipmentPageRes {

    private Long id;

    private Integer type;

    private String title;

    private String organizationName;

    private String memberName;

    private String createTime;

    private Integer verifyStatus;

    private Long verifyUserId;

    private String verifyUserName;

}
