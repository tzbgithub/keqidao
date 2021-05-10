package com.qidao.qidao.label.label.service.impl;

import com.qidao.qidao.label.label.domain.Label;
import com.qidao.qidao.label.label.mapper.CustomLabelMapper;
import com.qidao.qidao.label.label.service.CustomLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customLabelService")
public class CustomLabelServiceImpl implements CustomLabelService {

    @Resource
    private CustomLabelMapper customLabelMapper;

    @Override
    public List<Label> getByMemberId(Long memberId) {
        return customLabelMapper.getByMemberId(memberId);
    }

    @Override
    public List<Label> getByOrganizationId(Long organizationId) {
        return customLabelMapper.getByOrganizationId(organizationId);
    }
}
