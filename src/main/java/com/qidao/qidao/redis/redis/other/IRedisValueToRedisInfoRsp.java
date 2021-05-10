package com.qidao.qidao.redis.redis.other;

import com.qidao.qidao.redis.redis.domain.RedisInfoRsp;

/**
 *  缓存值转string
 * @author zhousen
 * @date 2021/03/30 14:29
 **/
public interface IRedisValueToRedisInfoRsp {
    /**
     * @Author zhousen
     * @Description 根据key获取值
     * @Date 2021/03/30 14:31
     * @param key
     * @return java.lang.String
     **/
    RedisInfoRsp getValue(String key);
}
