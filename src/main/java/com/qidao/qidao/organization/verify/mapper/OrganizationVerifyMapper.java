package com.qidao.qidao.organization.verify.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.organization.verify.domain.Verify;
import com.qidao.qidao.organization.verify.domain.VerifyListReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationVerifyMapper {

    Page<Verify> findVerifyList(VerifyListReq req);

}
