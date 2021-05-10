package com.qidao.qidao.redis.redis.other.impl;

import com.qidao.qidao.redis.redis.other.AbstractRedisValueToRedisInfoRsp;
import org.redisson.api.RBucket;
import org.redisson.api.RExpirable;

/**
 * @author zhousen
 * @date 2021/03/30 14:33
 **/
public class ObjectAbstractRedisValueToRedisInfoRspImpl extends AbstractRedisValueToRedisInfoRsp {

    @Override
    protected RExpirable getRedisValue(String key) {
        return getRedissonClient().getBucket(key);
    }

    @Override
    protected Object valueToObject(RExpirable rExpirable) {
        RBucket<Object> bucket = (RBucket<Object>) rExpirable;
        return bucket.get();
    }
}
