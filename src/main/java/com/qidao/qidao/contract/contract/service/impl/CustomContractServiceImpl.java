package com.qidao.qidao.contract.contract.service.impl;

import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.domain.ContractDetailRes;
import com.qidao.qidao.contract.contract.domain.ContractExportRes;
import com.qidao.qidao.contract.contract.domain.ContractRes;
import com.qidao.qidao.contract.contract.mapper.CustomContractMapper;
import com.qidao.qidao.contract.contract.service.CustomContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-03-02 15:00
 */
@Slf4j
@Service("customContractService")
public class CustomContractServiceImpl implements CustomContractService {
    @Resource
    private CustomContractMapper customContractMapper;

    /**
     * 查询合同列表
     *
     * @param contract : 查询条件对象
     * @return 查询结果列表
     */
    @Override
    public List<ContractRes> selectContractList(Contract contract) {
        return customContractMapper.selectContractList(contract);
    }

    /**
     * 查询平台签订的所有合同数
     *
     * @return 平台签订的所有合同数
     */
    @Override
    public int allData() {
        return customContractMapper.allData();
    }

    /**
     * 查询平台昨天签订的所有合同数
     *
     * @return 查询结果
     */
    @Override
    public int getYesterdayData() {
        LocalDate yesterday = LocalDate.now().minusDays(1L);
        LocalDateTime startTime = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(yesterday, LocalTime.MAX);
        return customContractMapper.getYesterdayData(startTime , endTime);
    }

    /**
     * 平台签订的所有合同金额总数
     *
     * @return 查询结果
     */
    @Override
    public int allMoney() {
        return customContractMapper.allMoney();
    }

    /**
     * 导出合同列表
     *
     * @param contract ：导出列表的查询条件对象
     * @return 查询列表
     */
    @Override
    public List<ContractExportRes> exportContract(Contract contract) {
        List<ContractRes> list = customContractMapper.selectContractList(contract);
        List<ContractExportRes> exList = new ArrayList<>();
        for (ContractRes con : list){
            ContractExportRes exCon = new ContractExportRes();
            BeanUtils.copyProperties(con, exCon);
            exList.add(exCon);
        }
        return exList;
    }

    /**
     * 通过合同ID查询合同信息
     *
     * @param id ：合同ID
     * @return 查询结果
     */
    @Override
    public ContractRes selectContract(Long id) {
        return customContractMapper.selectContract(id);
    }

    /**
     * 通过合同ID查询合同详细信息包括签订省份地区，确认时间，合同状态等信息
     *
     * @param id ：合同ID
     * @return 合同详细信息
     */
    @Override
    public ContractDetailRes selectContractDetailById(Long id) {
        return customContractMapper.selectContractDetailById(id);
    }
}
