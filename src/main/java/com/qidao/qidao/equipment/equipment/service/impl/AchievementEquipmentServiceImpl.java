package com.qidao.qidao.equipment.equipment.service.impl;

import java.util.List;
                                                                                                                                                                                                                                                                                                                import com.qidao.common.utils.security.ShiroUtils;

import com.qidao.qidao.equipment.equipment.domain.TAchievementEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.equipment.equipment.mapper.TAchievementEquipmentMapper;
import com.qidao.qidao.equipment.equipment. service.IAchievementEquipmentService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 设备/成果Service业务层处理
 *
 * @author autuan
 * @date 2021-02-04
 */
@Service
public class AchievementEquipmentServiceImpl implements IAchievementEquipmentService {
    @Autowired
    private TAchievementEquipmentMapper TAchievementEquipmentMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    /**
     * 查询设备/成果
     *
     * @param id 设备/成果ID
     * @return 设备/成果
     */
    @Override
    public TAchievementEquipment selectAchievementEquipmentById(Long id) {
        return TAchievementEquipmentMapper.selectAchievementEquipmentById(id);
    }

    /**
     * 查询设备/成果列表
     *
     * @param TAchievementEquipment 设备/成果
     * @return 设备/成果
     */
    @Override
    public List<TAchievementEquipment> selectAchievementEquipmentList(TAchievementEquipment TAchievementEquipment) {
        return TAchievementEquipmentMapper.selectAchievementEquipmentList(TAchievementEquipment);
    }

    /**
     * 新增设备/成果
     *
     * @param TAchievementEquipment 设备/成果
     * @return 结果
     */
    @Override
    public int insertAchievementEquipment(TAchievementEquipment TAchievementEquipment) {
                                                                                                                                                                                                                                                                                                                                TAchievementEquipment.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        TAchievementEquipment.setId(snowflakeIdWorker.nextId());
        return TAchievementEquipmentMapper.insertAchievementEquipment(TAchievementEquipment);
    }

    /**
     * 修改设备/成果
     *
     * @param TAchievementEquipment 设备/成果
     * @return 结果
     */
    @Override
    public int updateAchievementEquipment(TAchievementEquipment TAchievementEquipment) {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                            TAchievementEquipment.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return TAchievementEquipmentMapper.updateAchievementEquipment(TAchievementEquipment);
    }

    /**
     * 删除设备/成果对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAchievementEquipmentByIds(String ids) {
        return TAchievementEquipmentMapper.deleteAchievementEquipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备/成果信息
     *
     * @param id 设备/成果ID
     * @return 结果
     */
    @Override
    public int deleteAchievementEquipmentById(Long id) {
        return TAchievementEquipmentMapper.deleteAchievementEquipmentById(id);
    }
    


                                                                                                                                                                                    /**
             * 逻辑删除设备/成果对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return TAchievementEquipmentMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
