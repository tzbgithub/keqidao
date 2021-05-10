package com.qidao.qidao.redis.redis.other;

import com.qidao.qidao.redis.redis.other.impl.ListAbstractRedisValueToRedisInfoRspImpl;
import com.qidao.qidao.redis.redis.other.impl.MapAbstractRedisValueToRedisInfoRspImpl;
import com.qidao.qidao.redis.redis.other.impl.ObjectAbstractRedisValueToRedisInfoRspImpl;
import org.redisson.api.RType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhousen
 * @date 2021/03/31 11:14
 **/
@Component
public class AbstractRedisValueToRedisInfoRspFactory {

    @Autowired
    private RedissonClient redissonClient;

    private ConcurrentHashMap<RType,AbstractRedisValueToRedisInfoRsp> map = new ConcurrentHashMap<>(3);

    public IRedisValueToRedisInfoRsp getRedisValueToRedisInfoRsp(RType rType){
        AbstractRedisValueToRedisInfoRsp rsp = map.get(rType);
        if(rsp == null){
            synchronized (this){
                rsp = map.get(rType);
                if(rsp == null){
                    switch (rType){
                        case OBJECT:
                            rsp = new ObjectAbstractRedisValueToRedisInfoRspImpl();
                            break;
                        case LIST:
                            rsp = new ListAbstractRedisValueToRedisInfoRspImpl();
                            break;
                        case MAP:
                            rsp = new MapAbstractRedisValueToRedisInfoRspImpl();
                            break;
                    }
                    rsp.setRedissonClient(redissonClient);
                    rsp.setrType(rType);
                    map.put(rType,rsp);
                }
            }
        }
        return rsp;
    }
}
