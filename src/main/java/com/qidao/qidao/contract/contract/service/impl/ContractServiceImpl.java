package com.qidao.qidao.contract.contract.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.contract.contract.mapper.ContractMapper;
import com.qidao.qidao.contract.contract.domain.Contract;
import com.qidao.qidao.contract.contract.service.IContractService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 合同Service业务层处理
 *
 * @author autuan
 * @date 2021-03-02
 */
@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 查询合同
     *
     * @param id 合同ID
     * @return 合同
     */
    @Override
    public Contract selectContractById(Long id) {
        return contractMapper.selectContractById(id);
    }

    /**
     * 查询合同列表
     *
     * @param contract 合同
     * @return 合同
     */
    @Override
    public List<Contract> selectContractList(Contract contract) {
        return contractMapper.selectContractList(contract);
    }

    /**
     * 新增合同
     *
     * @param contract 合同
     * @return 结果
     */
    @Override
    public int insertContract(Contract contract) {
        contract.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        contract.setId(snowflakeIdWorker.nextId());
        return contractMapper.insertContract(contract);
    }

    /**
     * 修改合同
     *
     * @param contract 合同
     * @return 结果
     */
    @Override
    public int updateContract(Contract contract) {


        contract.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));


        return contractMapper.updateContract(contract);
    }

    /**
     * 删除合同对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContractByIds(String ids) {
        return contractMapper.deleteContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同信息
     *
     * @param id 合同ID
     * @return 结果
     */
    @Override
    public int deleteContractById(Long id) {
        return contractMapper.deleteContractById(id);
    }


    /**
     * 逻辑删除合同对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        return contractMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
