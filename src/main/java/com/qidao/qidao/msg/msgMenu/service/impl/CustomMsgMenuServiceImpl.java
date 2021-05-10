package com.qidao.qidao.msg.msgMenu.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenu;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuExample;
import com.qidao.qidao.msg.msgMenu.domain.MsgMenuListRes;
import com.qidao.qidao.msg.msgMenu.mapper.CustomMsgMenuMapper;
import com.qidao.qidao.msg.msgMenu.mapper.MsgMenuMapper;
import com.qidao.qidao.msg.msgMenu.service.CustomMsgMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customMsgMenuService")
public class CustomMsgMenuServiceImpl implements CustomMsgMenuService {

    @Resource
    private MsgMenuMapper msgMenuMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private CustomMsgMenuMapper customMsgMenuMapper;

    @Override
    public List<MsgMenu> getMsgMenu() {
        MsgMenuExample example = new MsgMenuExample();
        example.createCriteria().andDelFlagEqualTo((byte)0);
        return msgMenuMapper.selectByExample(example);
    }

    @Override
    public List<MsgMenuListRes> findMsgMenuList() {
        List<MsgMenuListRes> msgMenuList = customMsgMenuMapper.findMsgMenuList();
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        msgMenuList.forEach(msgMenuListRes -> {
            msgMenuListRes.setCreateBy(userMap.get(msgMenuListRes.getCreateById()));
        });
        return msgMenuList;
    }

    @Override
    public int open(Long id) {
        return msgMenuMapper.updateByPrimaryKeySelective(MsgMenu.builder().id(id).updateBy(ShiroUtils.getUserId()).status(0).build());
    }

    @Override
    public int close(Long id) {
        return msgMenuMapper.updateByPrimaryKeySelective(MsgMenu.builder().id(id).updateBy(ShiroUtils.getUserId()).status(1).build());
    }

    @Override
    public List<MsgMenu> findFather(Long id) {
        MsgMenuExample example = new MsgMenuExample();
        example.createCriteria().andStatusEqualTo(0).andPidEqualTo(0L).andDelFlagEqualTo((byte)0).andIdNotEqualTo(id);
        return msgMenuMapper.selectByExample(example);
    }

    @Override
    public List<MsgMenu> findSonByPid(Long pid) {
        MsgMenuExample example = new MsgMenuExample();
        example.createCriteria().andDelFlagEqualTo((byte)0).andStatusEqualTo(0).andPidEqualTo(pid);
        return msgMenuMapper.selectByExample(example);
    }

    @Override
    public int update(MsgMenu msgMenu) {
        if (msgMenu.getPid() != 0){
            MsgMenuExample son = new MsgMenuExample();
            son.createCriteria().andPidEqualTo(msgMenu.getId()).andStatusEqualTo(0).andDelFlagEqualTo((byte)0);
            List<MsgMenu> msgMenus = msgMenuMapper.selectByExample(son);
            if (CollUtil.isNotEmpty(msgMenus)){
                throw new BusinessException("该菜单拥有下属菜单，不能设置为二级菜单，请先删除下属菜单");
            }
        }
        msgMenu.setCreateBy(ShiroUtils.getUserId());
        msgMenu.setName(msgMenu.getName().replace(" " , ""));
        return msgMenuMapper.updateByPrimaryKeySelective(msgMenu);
    }
}
