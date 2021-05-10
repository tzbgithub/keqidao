package com.qidao.qidao.tools.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 晚成
 */
@Component
public class SnowflakeId {
    private final Snowflake snowflake ;

    public SnowflakeId( @Value("${worker.id}")Long workerId,  @Value("${datacenter.id}")Long datacenterId) {
        snowflake = IdUtil.createSnowflake(workerId,datacenterId);
    }

    public long nextId(){
       return snowflake.nextId();
    }
}
