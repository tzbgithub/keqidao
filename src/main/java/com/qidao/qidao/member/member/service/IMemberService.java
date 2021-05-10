package com.qidao.qidao.member.member.service;

import com.qidao.qidao.member.member.domain.TMember;
import java.util.List;

/**
 * 用户Service接口
 * 
 * @author autuan
 * @date 2020-12-16
 */
public interface IMemberService {
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    TMember selectMemberById(String id);

    /**
     * 查询用户列表
     * 
     * @param TMember 用户
     * @return 用户集合
     */
    List<TMember> selectMemberList(TMember TMember);

    /**
     * 新增用户
     * 
     * @param TMember 用户
     * @return 结果
     */
    int insertMember(TMember TMember);

    /**
     * 修改用户
     * 
     * @param TMember 用户
     * @return 结果
     */
    int updateMember(TMember TMember);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteMemberByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    int deleteMemberById(String id);

                                                                                                                                                                                                                        int logicDelByIds(String ids);
                                                                        }
