package com.qidao.qidao.redis.redis.other.impl;

import com.alibaba.fastjson.JSONObject;
import com.qidao.qidao.redis.redis.other.AbstractRedisValueToRedisInfoRsp;
import org.redisson.api.RExpirable;
import org.redisson.api.RMap;

/**
 * @author zhousen
 * @date 2021/03/30 14:33
 **/
public class MapAbstractRedisValueToRedisInfoRspImpl extends AbstractRedisValueToRedisInfoRsp {

    @Override
    protected RExpirable getRedisValue(String key) {
        return getRedissonClient().getMap(key);
    }

    @Override
    protected Object valueToObject(RExpirable rExpirable) {
        RMap<Object,Object> bucket = (RMap<Object,Object>) rExpirable;
        return JSONObject.toJSONString(bucket);
    }
}
