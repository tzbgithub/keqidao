package com.qidao.qidao.redis.redis.other;

import com.qidao.qidao.redis.redis.domain.RedisInfoRsp;
import org.redisson.api.RExpirable;
import org.redisson.api.RType;
import org.redisson.api.RedissonClient;

/**
 * @author zhousen
 * @date 2021/03/30 14:36
 **/
public abstract class AbstractRedisValueToRedisInfoRsp implements IRedisValueToRedisInfoRsp {

    private RedissonClient redissonClient;

    private RType rType;

    public void setrType(RType rType) {
        this.rType = rType;
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public RedisInfoRsp getValue(String key) {

        RedisInfoRsp rsp = new RedisInfoRsp();
        rsp.setType(this.rType.name());
        rsp.setKey(key);

        RExpirable redisValue = getRedisValue(key);
        if(!redisValue.isExists()){
            return null;
        }
        rsp.setValue(valueToObject(redisValue));
        rsp.setTtlTime(redisValue.remainTimeToLive()/1000);
        return rsp;
    }

    /**
     * @Author zhousen
     * @Description 获取redis中数据对象
     * @Date 2021/03/30 14:48
     * @param key
     * @return org.redisson.api.RExpirable
     **/
    protected abstract RExpirable getRedisValue(String key);

    /**
     * @Author zhousen
     * @Description 数据对象获取value
     * @Date 2021/03/30 14:48
     * @param rExpirable
     * @return java.lang.String
     **/
    protected abstract Object valueToObject(RExpirable rExpirable);


}
