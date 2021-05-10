package com.qidao.qidao.salesman.sales.mapper;

import com.qidao.qidao.salesman.sales.domain.*;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:39
 */
public interface CustomLinkOrganizationSalesmanMapper {
    /**
     * 根据查询条件查询推广人员推广的各组织列表
     *
     * @param linkSalesmanQuery ： 查询条件
     * @return 推广人员推广组织列表
     */
    List<LinkOrganizationSalesmanRes> getList(LinkSalesmanQuery linkSalesmanQuery);

    /**
     * 根据查询条件查询推广人员一段时间内的业绩
     *
     * @param linkSalesmanQuery ： 查询条件
     * @return 指定时间内的业绩列表
     */
    List<SalesPerformance> getPerformanceList(LinkSalesmanQuery linkSalesmanQuery);

    /**
     * 根据销售员ID查询销售员推广的组织ID集合
     *
     * @param salesmanId ： 销售员ID
     * @return 查询集合
     */
    List<String> getOrganizationListBySalesmanId(Long salesmanId);

    /**
     * 根据销售员ID导出销售员的推广列表
     *
     * @param salesmanId ： 销售员ID
     * @return 查询结果
     */
    List<Sales> export(String salesmanId);
}
