package com.qidao.qidao.redis.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * redis 值信息
 *
 * @author zhousen
 * @date 2021/03/30 13:38
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedisInfoRsp {
    /**
     * redis中数据类型
     */
    private String type;
    /**
     * 值
     */
    private Object value;
    /**
     * key
     */
    private String key;
    /**
     * 剩余过期时间
     */
    private Long ttlTime;
}
