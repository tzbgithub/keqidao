package com.qidao.qidao.channel.channel.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.channel.channel.domain.Channel;
import com.qidao.qidao.channel.channel.domain.ChannelEnum;
import com.qidao.qidao.channel.channel.domain.ChannelExample;
import com.qidao.qidao.channel.channel.domain.ChannelListRes;
import com.qidao.qidao.channel.channel.mapper.ChannelMapper;
import com.qidao.qidao.channel.channel.service.CustomChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customChannelService")
public class CustomChannelServiceImpl implements CustomChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    public List<ChannelListRes> getChannelList() {
        ChannelExample example = new ChannelExample();
        example.setOrderByClause("sequence desc");
        List<Channel> channels = channelMapper.selectByExample(example);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        Page<ChannelListRes> res = new Page<>();
        channels.forEach(channel -> {
            ChannelListRes channelRes = new ChannelListRes();
            BeanUtils.copyProperties(channel , channelRes);
            channelRes.setCreatorName(userMap.get(channel.getCreateBy()));
            channelRes.setReviserName(userMap.get(channel.getUpdateBy()));
            res.add(channelRes);
        });
        if (channels instanceof Page){
            res.setTotal(((Page<Channel>) channels).getTotal());
        }
        return res;
    }

    @Override
    public int stockFromSale(Long id) {
        return channelMapper.updateByPrimaryKeySelective(Channel.builder()
                .id(id)
                .delFlag(ChannelEnum.DEL_FLAG_TRUE.getCode())
                .updateBy(ShiroUtils.getUserId())
                .build());
    }

    @Override
    public int shelves(Long id) {
        return channelMapper.updateByPrimaryKeySelective(Channel.builder()
                .id(id)
                .updateBy(ShiroUtils.getUserId())
                .delFlag(ChannelEnum.DEL_FLAG_FALSE.getCode())
                .build());
    }
}
