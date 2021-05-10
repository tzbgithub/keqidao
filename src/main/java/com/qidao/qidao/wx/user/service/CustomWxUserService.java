package com.qidao.qidao.wx.user.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.User;

import java.util.List;

public interface CustomWxUserService {


    /**
     * 创建公众号的用户标签
     * @param name
     * @return
     */
    BaseResult tagsCreate( String name);

    /**
     * 获取公众号已创建的用户标签
     * @return
     */
    BaseResult tagsGet();

    /**
     * 更新公众号的用户标签
     * @param id 标签的id
     * @param name 新的名字
     * @return
     */
    BaseResult tagsUpdate( int id, String name);

    /**
     * 删除公众号的用户标签
     * @param id 标签的id
     * @return
     */
    BaseResult tagsDelete( int id);

    /**
     * 获取标签下粉丝列表
     * @param tagId 标签的id
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    BaseResult userTagGet( Integer tagId, String nextOpenid);

    /**
     * 批量为用户打标签
     * @param tagId tagId 标签的id
     * @param openids 用户openid的集合
     * @return
     */
    BaseResult tagsMembersBatchtagging( Integer tagId, String[] openids);

    /**
     * 批量为用户取消标签
     * @param tagId 标签的id
     * @param openids 用户openid的集合
     * @return
     */
    BaseResult tagsMembersBatchuntagging( Integer tagId, String[] openids);

    /**
     * 获取用户身上的标签列表
     * @param openid 某一个用户openid
     * @return
     */
    BaseResult tagsGetidlist( String openid);

    /**
     * 获取用户基本信息
     *
     * @param openid 某一个用户openid
     * @return
     */
    BaseResult userInfo(String openid);

    /**
     * 批量获取用户基本信息
     *
     * @param lang    国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @param openids 用户集合
     * @return
     */
    BaseResult userInfoBatchget(String lang, List<String> openids);

    /**
     * 批量获取用户基本信息
     * @return
     */
    List<User> userInfoBatchget();

    /**
     * 获取用户列表
     *
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    BaseResult userGet(String nextOpenid);

    /**
     * 获取用户数量
     */
    int getUserTotal();



    /**
     * 获取公众号的黑名单列表
     * @param beginOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    BaseResult tagsMembersGetblacklist( String beginOpenid);

    /**
     * 拉黑用户
     * @param openidList
     * @return
     */
    BaseResult tagsMembersBatchblacklist( String[] openidList);

    /**
     * 取消拉黑用户
     * @param openidList 拉出黑名单的用户的openid，一次拉黑最多允许20个
     * @return
     */
    BaseResult tagsMembersBatchunblacklist( String[] openidList);
















}
