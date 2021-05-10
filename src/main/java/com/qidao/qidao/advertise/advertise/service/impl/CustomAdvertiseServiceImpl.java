package com.qidao.qidao.advertise.advertise.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.advertise.advertise.domain.*;
import com.qidao.qidao.advertise.advertise.domain.enums.AdvertiseErrorEnum;
import com.qidao.qidao.advertise.advertise.mapper.AdvertiseMapper;
import com.qidao.qidao.advertise.advertise.mapper.CustomAdvertiseMapper;
import com.qidao.qidao.advertise.advertise.service.CustomAdvertiseService;
import com.qidao.qidao.link.advertiseCanal.domain.LinkAdvertiseCanal;
import com.qidao.qidao.link.advertiseCanal.domain.LinkAdvertiseCanalExample;
import com.qidao.qidao.link.advertiseCanal.mapper.LinkAdvertiseCanalMapper;
import com.qidao.qidao.link.dynamicChannel.domain.LinkDynamicChannel;
import com.qidao.qidao.link.dynamicChannel.mapper.LinkDynamicChannelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customAdvertiseServiceImpl")
public class CustomAdvertiseServiceImpl implements CustomAdvertiseService {

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private CustomAdvertiseMapper customAdvertiseMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private LinkDynamicChannelMapper linkDynamicChannelMapper;

    @Resource
    private AdvertiseMapper advertiseMapper;

    @Resource
    private LinkAdvertiseCanalMapper linkAdvertiseCanalMapper;

    private final DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<AdvertiseListRes> findAdvertise(AdvertiseListReq req) {
        List<AdvertiseListRes> advertise = customAdvertiseMapper.findAdvertise(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        advertise.forEach(advertiseListRes -> {
            advertiseListRes.setCreateByName(userMap.get(advertiseListRes.getCreateById()));
        });
        return advertise;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(AdvertiseAddReq req) {
        String title = req.getTitle().replace(" ", "");
        AdvertiseExample advertiseExample = new AdvertiseExample();
        advertiseExample.createCriteria().andTitleEqualTo(title).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
        Advertise queryAdvertise = advertiseMapper.selectOneByExample(advertiseExample);
        LinkAdvertiseCanalExample linkAdvertiseCanalExample = new LinkAdvertiseCanalExample();
        if (queryAdvertise != null){
            if (queryAdvertise.getLocation().equals(req.getLocation())){
                throw new BusinessException(AdvertiseErrorEnum.LOCATION_EXISTS);
            }
            linkAdvertiseCanalExample.createCriteria().andCanalIdEqualTo(req.getCanal()).andAdvertiseIdEqualTo(queryAdvertise.getId()).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
            LinkAdvertiseCanal linkAdvertiseCanal = linkAdvertiseCanalMapper.selectOneByExample(linkAdvertiseCanalExample);
            if (linkAdvertiseCanal != null){
                throw new BusinessException(AdvertiseErrorEnum.EXISTS);
            }
            return linkAdvertiseCanalMapper.insertSelective(LinkAdvertiseCanal.builder().id(snowflakeIdWorker53.nextId()).advertiseId(queryAdvertise.getId()).canalId(req.getCanal()).build());
        }
        Long advertiseId = snowflakeIdWorker53.nextId();
        linkAdvertiseCanalMapper.insertSelective(LinkAdvertiseCanal.builder().id(snowflakeIdWorker53.nextId()).advertiseId(advertiseId).canalId(req.getCanal()).build());
        Advertise advertise = new Advertise();
        BeanUtils.copyProperties(req , advertise);
        advertise.setId(advertiseId);
        advertise.setTitle(title);
        advertise.setCreateBy(ShiroUtils.getUserId());
        advertise.setStatus(0);
        advertise.setBeginTime(LocalDateTime.parse(req.getBeginTime() , timeDtf));
        advertise.setEndTime(LocalDateTime.parse(req.getEndTime() , timeDtf));
        JSONArray channelIds = JSONUtil.parseArray(req.getChannelIds());
        channelIds.forEach(channelId -> {
            linkDynamicChannelMapper.insertSelective(LinkDynamicChannel.builder()
                    .id(snowflakeIdWorker53.nextId())
                    .channelId(Long.parseLong(channelId.toString()))
                    .dynamicId(advertiseId)
                    .type(1)
                    .build());
        });
        return advertiseMapper.insertSelective(advertise);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int edit(AdvertiseEditReq req) {
        if (!req.getOldLocation().equals(req.getLocation())){
            AdvertiseExample advertiseExample = new AdvertiseExample();
            advertiseExample.createCriteria().andIdEqualTo(req.getId()).andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue()).andLocationEqualTo(req.getLocation());
            Advertise queryAdvertise = advertiseMapper.selectOneByExample(advertiseExample);
            if (queryAdvertise != null){
                throw new BusinessException(AdvertiseErrorEnum.LOCATION_EXISTS);
            }
        }
        if (!req.getOldCanal().equals(req.getCanal())){
            LinkAdvertiseCanalExample query = new LinkAdvertiseCanalExample();
            query.createCriteria().andAdvertiseIdEqualTo(req.getId()).andCanalIdEqualTo(req.getCanal());
            LinkAdvertiseCanal linkAdvertiseCanal = linkAdvertiseCanalMapper.selectOneByExample(query);
            if (linkAdvertiseCanal != null){
                throw new BusinessException(AdvertiseErrorEnum.EXISTS);
            }
            LinkAdvertiseCanalExample example = new LinkAdvertiseCanalExample();
            example.createCriteria().andAdvertiseIdEqualTo(req.getId()).andCanalIdEqualTo(req.getOldCanal());
            linkAdvertiseCanalMapper.updateByExampleSelective(LinkAdvertiseCanal.builder().canalId(req.getCanal()).build() , example);
        }
        Advertise advertise = new Advertise();
        BeanUtils.copyProperties(req , advertise);
        advertise.setBeginTime(LocalDateTime.parse(req.getBeginTime() , timeDtf));
        advertise.setEndTime(LocalDateTime.parse(req.getEndTime() , timeDtf));
        advertise.setUpdateBy(ShiroUtils.getUserId());
        return advertiseMapper.updateByPrimaryKeySelective(advertise);
    }

    @Override
    public AdvertiseDescriptionRes findAdvertiseDescription(Long id , Long canalId) {
        return customAdvertiseMapper.findAdvertiseDescription(id , canalId);
    }
}
