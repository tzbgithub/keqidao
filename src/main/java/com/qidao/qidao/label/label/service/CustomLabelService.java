package com.qidao.qidao.label.label.service;

import com.qidao.qidao.label.label.domain.Label;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CustomLabelService {

    List<Label> getByMemberId(Long memberId);

    List<Label> getByOrganizationId(Long organizationId);


}
