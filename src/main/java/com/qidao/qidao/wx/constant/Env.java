package com.qidao.qidao.wx.constant;

import com.qidao.common.utils.Threads;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

import java.util.concurrent.TimeUnit;

@Configuration
public class Env {
    private static final Logger log = LoggerFactory.getLogger(Threads.class);

    @Autowired
    RedissonClient redissonClient;

    public static final String APP_ID = "wx8757750483ef5899";

    public static final String APP_SECRET = "ac2075e29477b9877b987ec145dbcb07";

    public void deleteToken() {
        boolean flag = redissonClient.getBucket("accessToken").delete();
        if (flag == true) {
            log.info("删除成功");
        } else {
            log.info("删除失败");
        }
    }

    public String getAccessToken() {
        String accessToken = null;
        RBucket<Object> rbAT = redissonClient.getBucket("accessToken");
        //没有过期
        if (rbAT.isExists()) {
            accessToken = rbAT.get().toString();
            log.info("exist valid accessToken:{}", accessToken);
            return accessToken;
        }
        log.info("WeChat public account's accessToken is invalid or nonexistent !!!");
        //不存在或者过期，重新调微信的接口获取,并放入redis中存
        Token token = TokenAPI.token(APP_ID, APP_SECRET);
        accessToken = token.getAccess_token();
        int expiresIn = token.getExpires_in();
        redissonClient.getBucket("accessToken").set(accessToken, expiresIn, TimeUnit.SECONDS);
        log.info("Env -> getAccessToken -> redis save accessToken -> {}", accessToken);
        log.info("accessToken valid time -> {} seconds ", expiresIn);
        return accessToken;
    }
}



