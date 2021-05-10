package com.qidao.qidao.member.memberLabel.service;

import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionRes;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListRes;

import java.util.List;

public interface MemberLabelService {

    List<MemberLabelListRes> findLabel(MemberLabelListReq req);

    MemberLabelDescriptionRes findLabelById(Long id ,String labelId);

}
