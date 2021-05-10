package com.qidao.qidao.member.favor.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.member.favor.mapper.FavorMapper;
import com.qidao.qidao.member.favor.domain.Favor;
import com.qidao.qidao.member.favor.service.IFavorService;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.tools.snowflake.SnowflakeId;

import javax.annotation.Resource;


/**
 * 收藏Service业务层处理
 *
 * @author autuan
 * @date 2020-12-24
 */
@Service
public class FavorServiceImpl implements IFavorService {
    @Autowired
    private FavorMapper favorMapper;
    @Resource
    private SnowflakeId snowflakeId;

    /**
     * 查询收藏
     *
     * @param id 收藏ID
     * @return 收藏
     */
    @Override
    public Favor selectFavorById(Long id) {
        return favorMapper.selectFavorById(id);
    }

    /**
     * 查询收藏列表
     *
     * @param favor 收藏
     * @return 收藏
     */
    @Override
    public List<Favor> selectFavorList(Favor favor) {
        return favorMapper.selectFavorList(favor);
    }

    /**
     * 新增收藏
     *
     * @param favor 收藏
     * @return 结果
     */
    @Override
    public int insertFavor(Favor favor) {
        favor.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        favor.setId(snowflakeId.nextId());
        return favorMapper.insertFavor(favor);
    }

    /**
     * 修改收藏
     *
     * @param favor 收藏
     * @return 结果
     */
    @Override
    public int updateFavor(Favor favor) {


        favor.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return favorMapper.updateFavor(favor);
    }

    /**
     * 删除收藏对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFavorByIds(String ids) {
        return favorMapper.deleteFavorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收藏信息
     *
     * @param id 收藏ID
     * @return 结果
     */
    @Override
    public int deleteFavorById(Long id) {
        return favorMapper.deleteFavorById(id);
    }


    /**
     * 逻辑删除收藏对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return favorMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
