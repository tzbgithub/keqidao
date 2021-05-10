package com.qidao.qidao.server.server.service.impl;

import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.mapper.MemberMapper;
import com.qidao.qidao.server.server.domain.*;
import com.qidao.qidao.server.server.domain.enums.ServerErrorEnum;
import com.qidao.qidao.server.server.mapper.CustomServerMapper;
import com.qidao.qidao.server.server.mapper.ServerMapper;
import com.qidao.qidao.server.server.service.CustomServerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("customServerService")
public class CustomServerServiceImpl implements CustomServerService {


    @Resource
    private CustomServerMapper customServerMapper;

    @Resource
    private ServerMapper serverMapper;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Override
    public List<ServerListRes> findServer(ServerListReq req) {
        return customServerMapper.findServer(req);
    }

    @Override
    public int saveServer(ServerAddReq req) {
        Member member = memberMapper.selectByPrimaryKey(req.getMemberIdPartyA());
        if (member.getOrganizationId() == null){
            throw new BusinessException(ServerErrorEnum.NOT_ORGANIZATION);
        }
        if (member.getLevel() == 0){
            throw new BusinessException(ServerErrorEnum.NO_VIP);
        }
        if (member.getLevel() == -1){
            throw new BusinessException(ServerErrorEnum.FROZEN);
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(req.getSolutionTime()+" 00:00:00", df);
        Server server = new Server();
        BeanUtils.copyProperties(req , server);
        server.setOrganizedIdPartyA(member.getOrganizationId());
        server.setCreateBy(ShiroUtils.getUserId());
        server.setStatus(1);
        server.setSolutionTime(time);
        server.setId(snowflakeIdWorker53.nextId());
        return serverMapper.insertSelective(server);
    }

    @Override
    public ServerDescriptionRes serverDescription(Long id) {
        return customServerMapper.serverDescription(id);
    }

    @Override
    public int revoke(Long id) {
        Server server = new Server();
        server.setId(id);
        server.setUpdateBy(ShiroUtils.getUserId());
        server.setStatus(3);
        return serverMapper.updateByPrimaryKeySelective(server);
    }
}
