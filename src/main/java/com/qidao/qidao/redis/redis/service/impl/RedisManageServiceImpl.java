package com.qidao.qidao.redis.redis.service.impl;

import com.qidao.qidao.redis.redis.domain.RedisInfoRsp;
import com.qidao.qidao.redis.redis.other.AbstractRedisValueToRedisInfoRspFactory;
import com.qidao.qidao.redis.redis.service.IRedisManageService;
import org.redisson.api.RKeys;
import org.redisson.api.RType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存管理服务实现
 *
 * @author zhousen
 * @date 2021/03/30 09:49
 **/
@Service

public class RedisManageServiceImpl implements IRedisManageService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private AbstractRedisValueToRedisInfoRspFactory abstractRedisValueToRedisInfoRspFactory;

    @Override
    public List<String> keyAll() {
        RKeys rkeys = redissonClient.getKeys();
        //TODO keys太多可有修改为 getKeysWithLimit
        Iterable<String> keys = rkeys.getKeys();
        List<String > result = new ArrayList<>(Long.valueOf(rkeys.count()).intValue());
        for (String key : keys) {
            result.add(key);
        }
        return result;
    }

    @Override
    public List<String> queryKeys(String key) {
        RKeys rkeys = redissonClient.getKeys();
        Iterable<String> keysByPattern = rkeys.getKeysByPattern(key + "*");
        List<String > result = new ArrayList<>(Long.valueOf(rkeys.count()).intValue());
        for (String keyStr : keysByPattern) {
            result.add(keyStr);
        }
        return result;
    }

    @Override
    public RedisInfoRsp getInfoByKey(String key) {
        RType type = redissonClient.getKeys().getType(key);
        return abstractRedisValueToRedisInfoRspFactory.getRedisValueToRedisInfoRsp(type).getValue(key);
    }

    @Override
    public boolean setTTL(String key, Integer second) {
        return redissonClient.getBucket(key).expire(second.longValue(), TimeUnit.SECONDS);
    }

    @Override
    public boolean delete(String key) {
        return redissonClient.getBucket(key).delete();
    }
}
