package com.qidao.qidao.organization.verify.service.impl;

import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.organization.organization.domain.Organization;
import com.qidao.qidao.organization.organization.mapper.OrganizationMapper;
import com.qidao.qidao.organization.verify.domain.Verify;
import com.qidao.qidao.organization.verify.domain.VerifyListReq;
import com.qidao.qidao.organization.verify.domain.VerifyListRes;
import com.qidao.qidao.organization.verify.mapper.OrganizationVerifyMapper;
import com.qidao.qidao.organization.verify.service.OrganizationVerifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("organizationVerifyService")
public class OrganizationVerifyServiceImpl implements OrganizationVerifyService {

    @Resource
    private OrganizationVerifyMapper organizationVerifyMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<VerifyListRes> findVerifyList(VerifyListReq req) {
        List<Verify> verifyList = organizationVerifyMapper.findVerifyList(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        List<VerifyListRes> res = new ArrayList<>();
        verifyList.forEach(verify -> {
            VerifyListRes listRes = new VerifyListRes();
            BeanUtils.copyProperties(verify , listRes);
            listRes.setVerifyName(userMap.get(verify.getVerifyId()));
            listRes.setRecheckName(userMap.get(verify.getRecheckId()));
            res.add(listRes);
        });
        return res;
    }

    @Override
    public int verifyPass(Long id, String message) {
        return organizationMapper.updateByPrimaryKeySelective(Organization.builder()
                .id(id)
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(3L)
                .verifyReason(StringUtils.isEmpty(message) ? message : "审核通过")
                .verifyUserId(ShiroUtils.getUserId())
                .verifyTime(LocalDateTime.now())
                .build());
    }

    @Override
    public int recheckPass(Long id, String message) {
        return organizationMapper.updateByPrimaryKeySelective(Organization.builder()
                .id(id)
                .recheckId(ShiroUtils.getUserId())
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(2L)
                .verifyTime(LocalDateTime.now())
                .verifyReason(StringUtils.isEmpty(message) ? message : "审核通过")
                .build());
    }

    @Override
    public int recheckReject(Long id, String message) {
        return organizationMapper.updateByPrimaryKeySelective(Organization.builder()
                .id(id)
                .recheckId(ShiroUtils.getUserId())
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(1L)
                .verifyTime(LocalDateTime.now())
                .verifyReason(StringUtils.isEmpty(message) ? message : "审核失败，已驳回，如有问题请联系运营人员")
                .build());
    }

    @Override
    public int verifyReject(Long id, String message) {
        return organizationMapper.updateByPrimaryKeySelective(Organization.builder()
                .id(id)
                .verifyUserId(ShiroUtils.getUserId())
                .updateBy(ShiroUtils.getUserId())
                .verifyStatus(1L)
                .verifyTime(LocalDateTime.now())
                .verifyReason(StringUtils.isEmpty(message) ? message : "审核失败，已驳回，如有问题请联系运营人员")
                .build());
    }
}
