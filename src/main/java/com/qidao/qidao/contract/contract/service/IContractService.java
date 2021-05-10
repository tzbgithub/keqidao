package com.qidao.qidao.contract.contract.service;

import com.qidao.qidao.contract.contract.domain.Contract;
import java.util.List;

/**
 * 合同Service接口
 * 
 * @author autuan
 * @date 2021-03-02
 */
public interface IContractService {
    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    Contract selectContractById(Long id);

    /**
     * 查询合同列表
     * 
     * @param contract 合同
     * @return 合同集合
     */
    List<Contract> selectContractList(Contract contract);

    /**
     * 新增合同
     * 
     * @param contract 合同
     * @return 结果
     */
    int insertContract(Contract contract);

    /**
     * 修改合同
     * 
     * @param contract 合同
     * @return 结果
     */
    int updateContract(Contract contract);

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteContractByIds(String ids);

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    int deleteContractById(Long id);

                                                                                                                                                                                                                                    int logicDelByIds(String ids);
                                                                        }
