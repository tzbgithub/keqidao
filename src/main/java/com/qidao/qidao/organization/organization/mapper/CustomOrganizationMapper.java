package com.qidao.qidao.organization.organization.mapper;

import com.github.pagehelper.Page;
import com.qidao.common.utils.sql.Query;
import com.qidao.qidao.organization.organization.domain.Organization;
import com.qidao.qidao.organization.organization.domain.OrganizationListReq;
import com.qidao.qidao.organization.organization.domain.OrganizationListRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomOrganizationMapper {
    /**
     * 根据组织机构名称  类型   所属单位  查询对象
     */
     Organization findByNameAndTypeAndBelong(String name , Integer type , String belong);

    Page<Organization> organizationList(Query query);

    Page<OrganizationListRes> getOrganizationList(OrganizationListReq req);

}
