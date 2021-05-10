package com.qidao.qidao.contract.contract.mapper;

import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.domain.ContractDetailRes;
import com.qidao.qidao.contract.contract.domain.ContractRes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-03-02 15:02
 */
public interface CustomContractMapper {

    List<ContractRes> selectContractList(Contract contract);

    int allData();

    int getYesterdayData(LocalDateTime startTime, LocalDateTime endTime);

    int allMoney();

    ContractRes selectContract(Long id);

    ContractDetailRes selectContractDetailById(Long id);
}
