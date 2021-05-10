package com.qidao.qidao.equipment.equipment.service;

import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentAddReq;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentDescription;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentPageReq;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentPageRes;

import java.util.List;

public interface CustomAchievementEquipmentService {

    List<AchievementEquipmentPageRes> findAllEquipment(AchievementEquipmentPageReq req);

    AchievementEquipmentDescription findEquipmentDescription(Long id);

    int verifyPass(Long id, String msg);

    int verifyFail(Long id, String msg);

    int create(AchievementEquipmentAddReq req);

}
