package com.qidao.qidao.redis.redis.service;

import com.qidao.qidao.redis.redis.domain.RedisInfoRsp;

import java.util.List;

/**
 * 缓存管理
 *
 * @author zhousen
 * @date 2021/03/30 09:48
 **/
public interface IRedisManageService {

    /**
     * 获取redis中的全部key
     * @Author zhousen
     * @Date 2021/03/30 11:16
     * @return java.util.List<java.lang.String>
     **/
    List<String> keyAll();

    /**
     * 根据key查询redis中的keys
     * @Author zhousen
     * @Date 2021/03/30 13:26
     * @param key
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryKeys(String key);

    /**
     * 根据key查询详细信息
     * @Author zhousen
     * @Date 2021/03/30 13:35
     * @param key
     * @return java.lang.String
     **/
    RedisInfoRsp getInfoByKey(String key);

    /**
     * 设置过期时间  单位秒
     * @Author zhousen
     * @Date 2021/03/31 12:00
     * @param key  redis中的key
     * @param second  存活时间 单位秒
     * @return boolean
     **/
    boolean setTTL(String key,Integer second);

    /**
     * 删除
     * @Author zhousen
     * @Date 2021/03/30 13:44
     * @param key
     * @return true-删除成功 false-删除失败
     **/
    boolean delete(String key);
}
