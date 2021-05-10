package com.qidao.qidao.organization.organization.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.domain.MemberExample;
import com.qidao.qidao.organization.organization.domain.Organization;
import com.qidao.qidao.organization.organization.domain.OrganizationExample;
import com.qidao.qidao.organization.organization.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.organization.organization.mapper.TOrganizationMapper;
import com.qidao.qidao.organization.organization.domain.TOrganization;
import com.qidao.qidao.organization.organization. service.IOrganizationService;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.tools.snowflake.SnowflakeId;

import javax.annotation.Resource;


/**
 * 组织机构Service业务层处理
 *
 * @author autuan
 * @date 2020-12-17
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Autowired
    private TOrganizationMapper TOrganizationMapper;
    @Resource
    private SnowflakeId snowflakeId;
    @Autowired
    OrganizationMapper organizationMapper;
    /**
     * 查询组织机构
     *
     * @param id 组织机构ID
     * @return 组织机构
     */
    @Override
    public TOrganization selectOrganizationById(String id) {
        return TOrganizationMapper.selectOrganizationById(id);
    }

    /**
     * 查询组织机构列表
     *
     * @param TOrganization 组织机构
     * @return 组织机构
     */
    @Override
    public List<TOrganization> selectOrganizationList(TOrganization TOrganization) {
        return TOrganizationMapper.selectOrganizationList(TOrganization);
    }

    /**
     * 新增组织机构
     *
     * @param TOrganization 组织机构
     * @return 结果
     */
    @Override
    public int insertOrganization(TOrganization TOrganization) {
        byte flag = 0;
        OrganizationExample organizationExample = new OrganizationExample();
        organizationExample.createCriteria().andNameEqualTo(TOrganization.getName()).andDelFlagEqualTo(flag).andBelongEqualTo(TOrganization.getBelong());
        Organization organization = organizationMapper.selectOneByExample(organizationExample);
        if(organization!=null){
            throw  new RuntimeException("组织机构已存在");
        }
        TOrganization.setId(String.valueOf(snowflakeId.nextId()));
        return TOrganizationMapper.insertOrganization(TOrganization);
    }

    /**
     * 修改组织机构
     *
     * @param TOrganization 组织机构
     * @return 结果
     */
    @Override
    public int updateOrganization(TOrganization TOrganization) {

        byte flag= 0;
        String id = TOrganization.getId();
        OrganizationExample organizationExample = new OrganizationExample();
        organizationExample.createCriteria().andDelFlagEqualTo(flag).andIdEqualTo(Long.valueOf(id));
        Organization organizatio = organizationMapper.selectOneByExample(organizationExample);
        if (organizatio==null) {
            throw new BusinessException("组织机构不存在");
        }
        organizationExample.clear();
        TOrganization.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        return TOrganizationMapper.updateOrganization(TOrganization);
    }

    /**
     * 删除组织机构对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrganizationByIds(String ids) {
        return TOrganizationMapper.deleteOrganizationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除组织机构信息
     *
     * @param id 组织机构ID
     * @return 结果
     */
    @Override
    public int deleteOrganizationById(String id) {
        return TOrganizationMapper.deleteOrganizationById(id);
    }
    


                                                                                                                                                                                                                                                                                                                                    /**
             * 逻辑删除组织机构对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return TOrganizationMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
