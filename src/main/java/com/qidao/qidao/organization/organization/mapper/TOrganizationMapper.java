package com.qidao.qidao.organization.organization.mapper;

import com.qidao.qidao.organization.organization.domain.TOrganization;

import java.util.List;

/**
 * 组织机构Mapper接口
 * 
 * @author autuan
 * @date 2020-12-17
 */
public interface TOrganizationMapper {
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
     * 删除组织机构
     * 
     * @param id 组织机构ID
     * @return 结果
     */
    int deleteOrganizationById(String id);

    /**
     * 批量删除组织机构
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteOrganizationByIds(String[] ids);

                                                                                                                                                                                                                                                                                                                                    int logicDelByIds(String[] ids);
                                                                        }
