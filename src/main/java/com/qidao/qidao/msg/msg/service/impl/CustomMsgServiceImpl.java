package com.qidao.qidao.msg.msg.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.Page;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.msg.msg.domain.*;
import com.qidao.qidao.msg.msg.domain.enums.MsgErrorEnum;
import com.qidao.qidao.msg.msg.mapper.CustomMsgMapper;
import com.qidao.qidao.msg.msg.mapper.MsgMapper;
import com.qidao.qidao.msg.msg.service.CustomMsgService;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuExample;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuFather;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuSon;
import com.qidao.qidao.msg.msgMenu.mapper.MsgMenuMapper;
import com.qidao.qidao.msg.msgRecord.domain.MsgRecord;
import com.qidao.qidao.msg.msgRecord.mapper.MsgRecordMapper;
import com.qidao.qidao.tools.snowflake.SnowflakeId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customMsgService")
public class CustomMsgServiceImpl implements CustomMsgService {

    @Resource
    private CustomMsgMapper customMsgMapper;

    @Resource
    private MsgMapper msgMapper;

    @Resource
    private MsgRecordMapper msgRecordMapper;


    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private UserMapper userMapper;

    final DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<MsgListRes> findMsg(MsgListReq req) {
        Page<MsgListRes> res = customMsgMapper.findMsg(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        res.forEach(msgListRes -> {
            msgListRes.setCreateBy(userMap.get(msgListRes.getCreateById()));
        });
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(MsgAddReq req) {
        Long msgId = snowflakeIdWorker53.nextId();
        if (req.getTitle().length() > 32){
            throw new BusinessException(MsgErrorEnum.TITLE_TO_LONG);
        }
        if (!req.getMemberId().equals(-1L) && req.getReceiveType().equals(1)){
            MsgRecord msgRecord = new MsgRecord();
            msgRecord.setMsgId(msgId);
            msgRecord.setId(snowflakeIdWorker53.nextId());
            msgRecord.setCreateBy(ShiroUtils.getUserId());
            msgRecord.setMemberId(req.getMemberId());
            msgRecord.setSendTime(LocalDateTime.parse(req.getPushTime() , timeDtf));
            if (req.getType().equals(0)){
                msgRecord.setStatus(3);
            }
            msgRecordMapper.insertSelective(msgRecord);
        }
        Msg msg = new Msg();
        BeanUtils.copyProperties(req , msg);
        msg.setExpireTime(LocalDateTime.parse(req.getExpireTime() , timeDtf));
        msg.setPushTime(LocalDateTime.parse(req.getPushTime() , timeDtf));
        msg.setTitle(req.getTitle().replace(" " , ""));
        msg.setCreateBy(ShiroUtils.getUserId());
        msg.setStatus(0);
        msg.setTitleType(0);
        msg.setContentType(0);
        msg.setId(msgId);
        msg.setDelFlag((byte)0);
        return msgMapper.insertSelective(msg);
    }

    @Override
    public MsgDescriptionRes findMsgDescription(Long id) {
        return customMsgMapper.findMsgDescription(id);
    }

    @Override
    public int revoke(Long id) {

        return msgMapper.updateByPrimaryKeySelective(Msg.builder().id(id).status(-1).build());
    }

    @Override
    public int disable(Long id) {
        return msgMapper.updateByPrimaryKeySelective(Msg.builder().id(id).type(0).updateBy(ShiroUtils.getUserId()).build());
    }
}
