package com.qidao.qidao.label.label.mapper;

import com.qidao.qidao.label.label.domain.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomLabelMapper {

    List<Label> getByMemberId(Long memberId);

    List<Label> getByOrganizationId(Long organizationId);

}
