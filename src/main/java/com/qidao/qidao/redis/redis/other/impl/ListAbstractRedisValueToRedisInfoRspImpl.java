package com.qidao.qidao.redis.redis.other.impl;

import com.alibaba.fastjson.JSONObject;
import com.qidao.qidao.redis.redis.other.AbstractRedisValueToRedisInfoRsp;
import org.redisson.api.RExpirable;
import org.redisson.api.RList;

/**
 * @author zhousen
 * @date 2021/03/30 14:33
 **/
public class ListAbstractRedisValueToRedisInfoRspImpl extends AbstractRedisValueToRedisInfoRsp {
    @Override
    protected RExpirable getRedisValue(String key) {
        return getRedissonClient().getList(key);
    }

    @Override
    protected Object valueToObject(RExpirable rExpirable) {
        RList<Object> bucket = (RList<Object>) rExpirable;
        return JSONObject.toJSONString(bucket);
    }
}
