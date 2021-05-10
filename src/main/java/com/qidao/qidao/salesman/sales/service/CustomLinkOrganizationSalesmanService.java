package com.qidao.qidao.salesman.sales.service;

import com.qidao.qidao.salesman.sales.domain.*;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:40
 */
public interface CustomLinkOrganizationSalesmanService {
    /**
     * 根据查询条件查询推广人员推广列表
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
    List<SalesPerformanceRes> getPerformanceList(LinkSalesmanQuery linkSalesmanQuery);

    /**
     * 根据销售员ID导出销售员的推广列表
     *
     * @param salesmanId ： 销售员ID
     * @return 查询结果
     */
    List<SalesExcel> export(String salesmanId);

    /**
     * 授权
     * @param req
     * @return
     */
    Integer authorized(AuthorizedReq req);
}
