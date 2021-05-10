package com.qidao.qidao.wx.user.service.impl;

import com.qidao.qidao.wx.user.service.CustomWxUserService;
import com.qidao.qidao.wx.constant.Env;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.FollowResult;
import weixin.popular.bean.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class CustomWxUserServiceImpl implements CustomWxUserService {
    public static final Logger log = LoggerFactory.getLogger(CustomWxUserServiceImpl.class);

    @Autowired
    Env env;

    @Override
    public BaseResult tagsCreate(String name) {
        return UserAPI.tagsCreate(env.getAccessToken(), name);
    }

    @Override
    public BaseResult tagsGet() {
        return UserAPI.tagsGet(env.getAccessToken());
    }

    @Override
    public BaseResult tagsUpdate(int id, String name) {
        return UserAPI.tagsUpdate(env.getAccessToken(), id, name);
    }

    @Override
    public BaseResult tagsDelete(int id) {
        return UserAPI.tagsDelete(env.getAccessToken(), id);
    }

    @Override
    public BaseResult userTagGet(Integer tagId, String nextOpenid) {
        return UserAPI.userTagGet(env.getAccessToken(), tagId, nextOpenid);
    }

    @Override
    public BaseResult tagsMembersBatchtagging(Integer tagId, String[] openids) {
        return UserAPI.tagsMembersBatchtagging(env.getAccessToken(), tagId, openids);
    }

    @Override
    public BaseResult tagsMembersBatchuntagging(Integer tagId, String[] openids) {
        return UserAPI.tagsMembersBatchuntagging(env.getAccessToken(), tagId, openids);
    }

    @Override
    public BaseResult tagsGetidlist(String openid) {
        return UserAPI.tagsGetidlist(env.getAccessToken(), openid);
    }

    @Override
    public BaseResult userInfo(String openid) {
        return UserAPI.userInfo(env.getAccessToken(), openid);
    }

    @Override
    public BaseResult userInfoBatchget(String lang, List<String> openids) {
        return UserAPI.userInfoBatchget(env.getAccessToken(), lang, openids);
    }

    @Override
    public List<User> userInfoBatchget() {
        List<User> userInfoList = null;
        try {
            String at = env.getAccessToken();
            FollowResult.Data data = UserAPI.userGet(at, null).getData();
            String[] openidList = data.getOpenid();
            ArrayList<String> list = new ArrayList<String>();
            Collections.addAll(list, openidList);
            userInfoList = UserAPI.userInfoBatchget(at, null, list).getUser_info_list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoList;
    }

    @Override
    public BaseResult userGet(String nextOpenid) {
        return UserAPI.userGet(env.getAccessToken(), nextOpenid);
    }

    @Override
    public int getUserTotal() {
        int total = 0;
        try {
            FollowResult fr = UserAPI.userGet(env.getAccessToken(), null);
            total =  fr.getTotal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("微信用户数量:{}", total);
        return total;
    }

    @Override
    public BaseResult tagsMembersGetblacklist(String beginOpenid) {
        return UserAPI.tagsMembersGetblacklist(env.getAccessToken(), beginOpenid);
    }

    @Override
    public BaseResult tagsMembersBatchblacklist(String[] openidList) {
        return UserAPI.tagsMembersBatchblacklist(env.getAccessToken(), openidList);
    }

    @Override
    public BaseResult tagsMembersBatchunblacklist(String[] openidList) {
        return UserAPI.tagsMembersBatchunblacklist(env.getAccessToken(), openidList);
    }


}
