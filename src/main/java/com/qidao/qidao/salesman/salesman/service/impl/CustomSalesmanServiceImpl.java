package com.qidao.qidao.salesman.salesman.service.impl;

import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.Md5Utils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.salesman.salesman.domain.Salesman;
import com.qidao.qidao.salesman.salesman.domain.SalesmanDO;
import com.qidao.qidao.salesman.salesman.domain.SalesmanEnum;
import com.qidao.qidao.salesman.salesman.mapper.CustomSalesmanMapper;
import com.qidao.qidao.salesman.salesman.mapper.SalesmanMapper;
import com.qidao.qidao.salesman.salesman.service.ICustomSalesmanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 销售员Service业务层处理
 *
 * @author autuan
 * @date 2020-12-23
 */
@Slf4j
@Service
public class CustomSalesmanServiceImpl implements ICustomSalesmanService {
    @Resource
    private SalesmanMapper salesmanMapper;

    @Resource
    private CustomSalesmanMapper customSalesmanMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    /**
     * 新增销售员
     *
     * @param salesman 销售员
     * @return 结果
     */
    @Override
    public int insertSalesman(Salesman salesman) {
        log.info("CustomSalesmanServiceImpl -> insertSalesman -> Salesman salesman : {}", salesman);
        Salesman salesmanByName = customSalesmanMapper.getSalesmanByName(salesman.getName());
        if (salesmanByName != null){
            throw new BusinessException("名字不能重复");
        }
        salesman.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        salesman.setId(snowflakeIdWorker.nextId());
        salesman.setPassword(Md5Utils.encryptPassword(salesman.getPassword()));
        int count = salesmanMapper.insertSalesman(salesman);
        log.info("CustomSalesmanServiceImpl -> insertSalesman -> Return int : {}", count);
        return count;
    }

    /**
     * 批量重置销售员密码为123456
     *
     * @param ids 需要重置密码的销售员ID
     * @return 结果
     */
    @Override
    public int resetPasswordSalesmanByIds(String ids) {
        log.info("CustomSalesmanServiceImpl -> resetPasswordSalesman -> String ids : {}", ids);
        SalesmanDO salesmanDO = SalesmanDO.builder()
                .ids(Convert.toStrArray(ids))
                .password(Md5Utils.encryptPassword(SalesmanEnum.INITIAL_PASSWORD.getValue()))
                .build();
        salesmanDO.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        int count =  customSalesmanMapper.resetPasswordSalesmanByIds(salesmanDO);
        log.info("CustomSalesmanServiceImpl -> resetPasswordSalesman -> Return int : {}", count);
        return count;
    }

    @Override
    public List<Salesman> getSalesman(String code) {
        return customSalesmanMapper.getSalesman(code);
    }
}
