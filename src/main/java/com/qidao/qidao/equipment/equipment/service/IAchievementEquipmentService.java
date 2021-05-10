package com.qidao.qidao.equipment.equipment.service;

import com.qidao.qidao.equipment.equipment.domain.TAchievementEquipment;

import java.util.List;

/**
 * 设备/成果Service接口
 * 
 * @author autuan
 * @date 2021-02-04
 */
public interface IAchievementEquipmentService {
    /**
     * 查询设备/成果
     * 
     * @param id 设备/成果ID
     * @return 设备/成果
     */
    TAchievementEquipment selectAchievementEquipmentById(Long id);

    /**
     * 查询设备/成果列表
     * 
     * @param TAchievementEquipment 设备/成果
     * @return 设备/成果集合
     */
    List<TAchievementEquipment> selectAchievementEquipmentList(TAchievementEquipment TAchievementEquipment);

    /**
     * 新增设备/成果
     * 
     * @param TAchievementEquipment 设备/成果
     * @return 结果
     */
    int insertAchievementEquipment(TAchievementEquipment TAchievementEquipment);

    /**
     * 修改设备/成果
     * 
     * @param TAchievementEquipment 设备/成果
     * @return 结果
     */
    int updateAchievementEquipment(TAchievementEquipment TAchievementEquipment);

    /**
     * 批量删除设备/成果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAchievementEquipmentByIds(String ids);

    /**
     * 删除设备/成果信息
     * 
     * @param id 设备/成果ID
     * @return 结果
     */
    int deleteAchievementEquipmentById(Long id);

                                                                                                                                                                        int logicDelByIds(String ids);
                                                                        }
