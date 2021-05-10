package com.qidao.qidao.salesman.sales.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.qidao.qidao.equipment.equipment.mapper.CustomAchievementEquipmentMapper;
import com.qidao.qidao.salesman.sales.domain.*;
import com.qidao.qidao.salesman.sales.mapper.CustomLinkOrganizationSalesmanMapper;
import com.qidao.qidao.salesman.sales.mapper.LinkOrganizationSalesmanMapper;
import com.qidao.qidao.salesman.sales.service.CustomLinkOrganizationSalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-02-01 13:41
 */
@Service
@Slf4j
public class CustomLinkOrganizationSalesmanServiceImpl implements CustomLinkOrganizationSalesmanService {

    @Resource
    private CustomLinkOrganizationSalesmanMapper customLinkOrganizationSalesmanMapper;
    @Resource
    private LinkOrganizationSalesmanMapper linkOrganizationSalesmanMapper;
    @Resource
    private CustomAchievementEquipmentMapper customAchievementEquipmentMapper;


    /**
     * 根据查询条件查询推广人员推广列表
     *
     * @param linkSalesmanQuery ： 查询条件
     * @return 推广人员推广组织列表
     */
    @Override
    public List<LinkOrganizationSalesmanRes> getList(LinkSalesmanQuery linkSalesmanQuery) {
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> getList -> start -> linkSalesmanQuery : {}", linkSalesmanQuery);
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> getList -> end");
        return customLinkOrganizationSalesmanMapper.getList(linkSalesmanQuery);
    }

    /**
     * 根据查询条件查询推广人员一段时间内的业绩
     *
     * @param linkSalesmanQuery ： 查询条件
     * @return 指定时间内的业绩列表
     */
    @Override
    public List<SalesPerformanceRes> getPerformanceList(LinkSalesmanQuery linkSalesmanQuery) {
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> getPerformanceList -> start -> linkSalesmanQuery : {}", linkSalesmanQuery);
        List<SalesPerformance> list = customLinkOrganizationSalesmanMapper.getPerformanceList(linkSalesmanQuery);
        List<SalesPerformanceRes> resList = new ArrayList<>();
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> getPerformanceList -> CollUtil.isNotEmpty(list) : {}", (CollUtil.isNotEmpty(list)));
        if(CollUtil.isNotEmpty(list)){
            for(SalesPerformance sp : list){
                Integer equipments = 0;
                List<String> organizationList = customLinkOrganizationSalesmanMapper.getOrganizationListBySalesmanId(sp.getSalesmanId());
                for(String organizationId : organizationList){
                    equipments += customAchievementEquipmentMapper.getEquipmentsByOrganizationId(organizationId);
                }
                SalesPerformanceRes salesPerformanceRes = SalesPerformanceRes.builder()
                        .performance(sp.getPerformance())
                        .salesmanName(sp.getSalesmanName())
                        .salesmanId(sp.getSalesmanId())
                        .equipments(equipments)
                        .build();
                resList.add(salesPerformanceRes);
            }
        }
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> getPerformanceList -> end");
        return resList;
    }

    /**
     * 根据销售员ID导出销售员的推广列表
     *
     * @param salesmanId ： 销售员ID
     * @return 查询结果
     */
    @Override
    public List<SalesExcel> export(String salesmanId) {
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> export -> start -> linkSalesmanQuery : {}", salesmanId);
        List<Sales> salesList = customLinkOrganizationSalesmanMapper.export(salesmanId);
        List<SalesExcel> excelList = new ArrayList<>();
        for(Sales sales : salesList){
            String type = null;
            log.info("CustomLinkOrganizationSalesmanServiceImpl -> export -> sales.getType() == 0 ：{}", (sales.getType() == 0));
            if(sales.getType() == 0){
                type = "当前运营人员邀请";
            }else {
                type = "其他运营人员邀请";
            }
            SalesExcel salesExcel = SalesExcel.builder()
                    .organizationName(sales.getOrganizationName())
                    .salesmanName(sales.getSalesmanName())
                    .type(type)
                    .build();
            excelList.add(salesExcel);
        }
        log.info("CustomLinkOrganizationSalesmanServiceImpl -> export -> end");
        return excelList;
    }


    @Override
    public Integer authorized(AuthorizedReq req) {
        LinkOrganizationSalesman bean = new LinkOrganizationSalesman();
        BeanUtil.copyProperties(req,bean);
        bean.setAuthoorized(1L);
        return linkOrganizationSalesmanMapper.updateLinkOrganizationSalesman(bean);
    }
}
