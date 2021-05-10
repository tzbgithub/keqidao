package com.qidao.qidao.member.subscribe.mapper;

import com.qidao.qidao.member.subscribe.domain.TSubscribe;

import java.util.List;

/**
 * 关注Mapper接口
 * 
 * @author autuan
 * @date 2020-12-24
 */
public interface TSubscribeMapper {
    /**
     * 查询关注
     * 
     * @param id 关注ID
     * @return 关注
     */
    TSubscribe selectSubscribeById(Long id);

    /**
     * 查询关注列表
     * 
     * @param TSubscribe 关注
     * @return 关注集合
     */
    List<TSubscribe> selectSubscribeList(TSubscribe TSubscribe);

    /**
     * 新增关注
     * 
     * @param TSubscribe 关注
     * @return 结果
     */
    int insertSubscribe(TSubscribe TSubscribe);

    /**
     * 修改关注
     * 
     * @param TSubscribe 关注
     * @return 结果
     */
    int updateSubscribe(TSubscribe TSubscribe);

    /**
     * 删除关注
     * 
     * @param id 关注ID
     * @return 结果
     */
    int deleteSubscribeById(Long id);

    /**
     * 批量删除关注
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSubscribeByIds(String[] ids);

                                                                                                                        int logicDelByIds(String[] ids);
                                                                        }
