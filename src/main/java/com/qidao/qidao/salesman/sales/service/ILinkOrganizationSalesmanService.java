package com.qidao.qidao.salesman.sales.service;

import com.qidao.qidao.salesman.sales.domain.LinkOrganizationSalesman;
import java.util.List;

/**
 * 销售关联组织机构Service接口
 * 
 * @author autuan
 * @date 2021-03-09
 */
public interface ILinkOrganizationSalesmanService {
    /**
     * 查询销售关联组织机构
     * 
     * @param id 销售关联组织机构ID
     * @return 销售关联组织机构
     */
    LinkOrganizationSalesman selectLinkOrganizationSalesmanById(Long id);

    /**
     * 查询销售关联组织机构列表
     * 
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 销售关联组织机构集合
     */
    List<LinkOrganizationSalesman> selectLinkOrganizationSalesmanList(LinkOrganizationSalesman linkOrganizationSalesman);

    /**
     * 新增销售关联组织机构
     * 
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 结果
     */
    int insertLinkOrganizationSalesman(LinkOrganizationSalesman linkOrganizationSalesman);

    /**
     * 修改销售关联组织机构
     * 
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 结果
     */
    int updateLinkOrganizationSalesman(LinkOrganizationSalesman linkOrganizationSalesman);

    /**
     * 批量删除销售关联组织机构
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLinkOrganizationSalesmanByIds(String ids);

    /**
     * 删除销售关联组织机构信息
     * 
     * @param id 销售关联组织机构ID
     * @return 结果
     */
    int deleteLinkOrganizationSalesmanById(Long id);

                                                                                    int logicDelByIds(String ids);
                                                                                                                        }
