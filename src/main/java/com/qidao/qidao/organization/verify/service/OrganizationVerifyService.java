package com.qidao.qidao.organization.verify.service;

import com.qidao.qidao.organization.verify.domain.Verify;
import com.qidao.qidao.organization.verify.domain.VerifyListReq;
import com.qidao.qidao.organization.verify.domain.VerifyListRes;

import java.util.List;

public interface OrganizationVerifyService {

    List<VerifyListRes> findVerifyList(VerifyListReq req);

    int verifyPass(Long id , String message);

    int recheckPass(Long id , String message);

    int recheckReject(Long id , String message);

    int verifyReject(Long id , String message);

}
