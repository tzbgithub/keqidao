package com.qidao.qidao.member.memberLabel.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.StringUtils;
import com.qidao.project.system.user.domain.User;
import com.qidao.qidao.dynamic.domain.CustomDynamic;
import com.qidao.qidao.dynamic.mapper.CustomDynamicMapper;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelDescriptionRes;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListReq;
import com.qidao.qidao.member.memberLabel.domain.MemberLabelListRes;
import com.qidao.qidao.member.memberLabel.domain.enums.MemberLabelErrorEnum;
import com.qidao.qidao.member.memberLabel.mapper.MemberLabelMapper;
import com.qidao.qidao.member.memberLabel.service.MemberLabelService;
import com.qidao.qidao.server.server.domain.Server;
import com.qidao.qidao.server.server.domain.ServerExample;
import com.qidao.qidao.server.server.mapper.ServerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("memberLabelService")
public class MemberLabelServiceImpl implements MemberLabelService {

    @Resource
    private MemberLabelMapper memberLabelMapper;

    @Resource
    private CustomDynamicMapper customDynamicMapper;

    @Resource
    private ServerMapper serverMapper;

    @Override
    public List<MemberLabelListRes> findLabel(MemberLabelListReq req) {
        Page<MemberLabelListRes> memberLabel = memberLabelMapper.findLabel(req);
        List<Long> memberId = memberLabel.getResult().stream().map(MemberLabelListRes::getMemberId).collect(Collectors.toList());
        Map<Long, Long> dynamic = null;
        Map<Long, Long> server = null;
        if (CollUtil.isNotEmpty(memberId)){
            List<CustomDynamic> dynamics = customDynamicMapper.getDynamicByIds(memberId);
            dynamic = dynamics.stream().collect(Collectors.toMap(CustomDynamic::getMemberId, CustomDynamic::getId, (oldV, newV) -> newV));
            ServerExample serverExample = new ServerExample();
            serverExample.createCriteria().andMemberIdPartyAIn(memberId).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue()).andStatusNotEqualTo(0);
            List<Server> servers = serverMapper.selectByExample(serverExample);
            server = servers.stream().collect(Collectors.toMap(Server::getMemberIdPartyA, Server::getId, (oldV, newV) -> newV));
        }

        if (CollUtil.isNotEmpty(memberLabel.getResult())){
            Map<Long, Long> finalDynamic = dynamic;
            Map<Long, Long> finalServer = server;
            memberLabel.getResult().forEach(memberLabelListRes -> {
                memberLabelListRes.setDynamic("无");
                memberLabelListRes.setServer("无");
                if (CollUtil.isNotEmpty(finalDynamic) && finalDynamic.get(memberLabelListRes.getMemberId()) != null){
                    memberLabelListRes.setDynamic("有");
                }
                if (CollUtil.isNotEmpty(finalServer) && finalServer.get(memberLabelListRes.getMemberId()) != null){
                    memberLabelListRes.setServer("有");
                }
            });
        }
        return memberLabel;
    }

    @Override
    public MemberLabelDescriptionRes findLabelById(Long id ,String labelId) {
        System.err.println(id);
        MemberLabelDescriptionRes memberLabel = memberLabelMapper.findLabelById(id, labelId.equals("NaN")? 0L : Long.parseLong(labelId));
        if (ObjectUtil.isEmpty(memberLabel)){
            throw new BusinessException(MemberLabelErrorEnum.LABEL_IS_NOT);
        }
        memberLabel.setServer("无");
        memberLabel.setDynamic("无");

        ServerExample serverExample = new ServerExample();
        serverExample.createCriteria().andMemberIdPartyAEqualTo(id).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue()).andStatusNotEqualTo(0);
        List<Server> servers = serverMapper.selectByExample(serverExample);
        if (CollUtil.isNotEmpty(servers)){
            memberLabel.setServer("有");
        }
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        List<CustomDynamic> dynamics = customDynamicMapper.getDynamicByIds(ids);
        if (CollUtil.isNotEmpty(dynamics)){
            memberLabel.setDynamic("有");
        }
        System.err.println(memberLabel);
        return memberLabel;
    }
}
