package com.qidao.qidao.organization.organization.service;
import com.github.pagehelper.Page;
import com.qidao.common.dto.OrganizationDto;
import com.qidao.common.dto.UpdateOriganizationDto;
import com.qidao.framework.web.ResponseResult;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.organization.organization.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CustomOrganizationService {
    //ResponseResult save (OrganizationDto organizationDto);
    /**
     * 修改实验室
     */
    void  updateOrganization(UpdateOriganizationDto updateOriganizationDto);

    Page<OrganizationListRes> getOrganizationList(OrganizationListReq req);

    int saveOrgan(OrganizationAddReq req);

    Organization toUpdate(Long id);

    int update(OrganizationUpdateReq req);

    List<Member> getOrganMember(Long organId);

    List<Organization> findByName(@Param("name") String name);
}
