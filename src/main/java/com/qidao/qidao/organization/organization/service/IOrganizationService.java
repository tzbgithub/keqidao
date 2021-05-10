package com.qidao.qidao.organization.organization.service;

import com.qidao.qidao.organization.organization.domain.TOrganization;

import java.util.List;

/**
 * 组织机构Service接口
 * 
 * @author autuan
 * @date 2020-12-17
 */
public interface IOrganizationService {
    /**
     * 查询组织机构
     * 
     * @param id 组织机构ID
     * @return 组织机构
     */
    TOrganization selectOrganizationById(String id);

    /**
     * 查询组织机构列表
     * 
     * @param TOrganization 组织机构
     * @return 组织机构集合
     */
    List<TOrganization> selectOrganizationList(TOrganization TOrganization);

    /**
     * 新增组织机构
     * 
     * @param TOrganization 组织机构
     * @return 结果
     */
    int insertOrganization(TOrganization TOrganization);

    /**
     * 修改组织机构
     * 
     * @param TOrganization 组织机构
     * @return 结果
     */
    int updateOrganization(TOrganization TOrganization);

    /**
     * 批量删除组织机构
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteOrganizationByIds(String ids);

    /**
     * 删除组织机构信息
     * 
     * @param id 组织机构ID
     * @return 结果
     */
    int deleteOrganizationById(String id);

                                                                                                                                                                                                                                                                                                                        int logicDelByIds(String ids);
                                                                        }
