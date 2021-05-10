package com.qidao.qidao.equipment.equipment.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentDescription;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentPageReq;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentPageRes;
import org.apache.ibatis.annotations.Param;

/**
 * @author: xinfeng
 * @create: 2021-02-04 10:27
 */
public interface CustomAchievementEquipmentMapper {

    /**
     * 根据organization_id 查询该组织发布的成果数
     *
     * @param organizationId ： 组织ID
     * @return 查询结果
     */
    Integer getEquipmentsByOrganizationId(@Param("organizationId") String organizationId);

    Page<AchievementEquipmentPageRes> findEquipmentPage(AchievementEquipmentPageReq req);

    AchievementEquipmentDescription findEquipmentDescription(Long id);
}
