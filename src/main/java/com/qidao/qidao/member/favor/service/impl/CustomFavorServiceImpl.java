package com.qidao.qidao.member.favor.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.member.favor.domain.*;
import com.qidao.qidao.member.favor.mapper.CustomFavorMapper;
import com.qidao.qidao.member.favor.mapper.FavorMapper;
import com.qidao.qidao.member.favor.service.CustomFavorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customFavorService")
public class CustomFavorServiceImpl implements CustomFavorService {

    @Resource
    private CustomFavorMapper customFavorMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Resource
    private FavorMapper favorMapper;

    @Override
    public List<FavorPageRes> getFavorPage(FavorPageReq req) {
        return customFavorMapper.getFavorPage(req);
    }

    @Override
    public List<FavorMemberRes> getMember(String name) {
        return customFavorMapper.getMember(name);
    }

    @Override
    public List<FavorDynamicRes> getDynamic(String title) {
        return customFavorMapper.getDynamic(title);
    }

    @Override
    public int create(CreateReq req) {
        FavorDynamicInfoRes dynamicInfo = customFavorMapper.getDynamicInfo(req.getDynamicId());
        Favor favor = new Favor();
        if (dynamicInfo != null){
            favor.setId(snowflakeIdWorker53.nextId());
            favor.setDynamicId(dynamicInfo.getId());
            favor.setDynamicImg(dynamicInfo.getImg());
            favor.setDynamicCommentNum(dynamicInfo.getCommentNum());
            favor.setDynamicLikeNum(dynamicInfo.getLikeNum());
            favor.setDynamicTitle(dynamicInfo.getTitle());
            favor.setMemberId(req.getMemberId());
            favor.setDynamicPushMemberId(dynamicInfo.getMemberId());
            favor.setDynamicSummary(dynamicInfo.getSummary());
            favor.setDynamicPushTime(dynamicInfo.getPublishTime());
            List<DynamicLabel> labels = dynamicInfo.getLabels();
            String labelStr = "";
            if (CollUtil.isNotEmpty(labels)){
                 labelStr = JSON.toJSONString(labels);
            }
            favor.setDynamicLabelStr(labelStr);
            System.err.println(favor);
            return  favorMapper.insertFavor(favor);
        }
        return 0;
    }
}
