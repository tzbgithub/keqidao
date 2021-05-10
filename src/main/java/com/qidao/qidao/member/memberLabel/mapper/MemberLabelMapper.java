package com.qidao.qidao.member.memberLabel.mapper;

import com.github.pagehelper.Page;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionRes;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberLabelMapper {

    Page<MemberLabelListRes> findLabel(MemberLabelListReq req);

    MemberLabelDescriptionRes findLabelById(Long memberId , Long labelId);

}
