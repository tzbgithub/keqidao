package com.qidao.qidao.contract.contract.service;

import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.domain.ContractDetailRes;
import com.qidao.qidao.contract.contract.domain.ContractExportRes;
import com.qidao.qidao.contract.contract.domain.ContractRes;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-03-02 15:00
 */
public interface CustomContractService {
    /**
     * 查询合同列表
     *
     * @param contract : 查询条件对象
     * @return 查询结果列表
     */
    List<ContractRes> selectContractList(Contract contract);

    /**
     * 查询平台签订的所有合同数
     *
     * @return 平台签订的所有合同数
     */
    int allData();

    /**
     * 查询平台昨天签订的所有合同数
     *
     * @return 查询结果
     */
    int getYesterdayData();

    /**
     * 平台签订的所有合同金额总数
     *
     * @return 查询结果
     */
    int allMoney();

    /**
     * 导出合同列表
     *
     * @param contract ：导出列表的查询条件对象
     * @return 查询列表
     */
    List<ContractExportRes> exportContract(Contract contract);

    /**
     * 通过合同ID查询合同信息
     *
     * @param id ：合同ID
     * @return 查询结果
     */
    ContractRes selectContract(Long id);

    /**
     * 通过合同ID查询合同详细信息包括签订省份地区，确认时间，合同状态等信息
     *
     * @param id ：合同ID
     * @return 合同详细信息
     */
    ContractDetailRes selectContractDetailById(Long id);
}
