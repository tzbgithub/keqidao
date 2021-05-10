package com.qidao.qidao.member.favor.service;

import com.qidao.qidao.member.favor.domain.Favor;
import java.util.List;

/**
 * 收藏Service接口
 * 
 * @author autuan
 * @date 2020-12-24
 */
public interface IFavorService {
    /**
     * 查询收藏
     * 
     * @param id 收藏ID
     * @return 收藏
     */
    Favor selectFavorById(Long id);

    /**
     * 查询收藏列表
     * 
     * @param favor 收藏
     * @return 收藏集合
     */
    List<Favor> selectFavorList(Favor favor);

    /**
     * 新增收藏
     * 
     * @param favor 收藏
     * @return 结果
     */
    int insertFavor(Favor favor);

    /**
     * 修改收藏
     * 
     * @param favor 收藏
     * @return 结果
     */
    int updateFavor(Favor favor);

    /**
     * 批量删除收藏
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteFavorByIds(String ids);

    /**
     * 删除收藏信息
     * 
     * @param id 收藏ID
     * @return 结果
     */
    int deleteFavorById(Long id);

                                                                                                                                    int logicDelByIds(String ids);
                                                                        }
