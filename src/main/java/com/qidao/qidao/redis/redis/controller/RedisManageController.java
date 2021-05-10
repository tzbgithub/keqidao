package com.qidao.qidao.redis.redis.controller;

import com.qidao.qidao.redis.redis.domain.RedisInfoRsp;
import com.qidao.qidao.redis.redis.service.IRedisManageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 缓存管理控制器
 *
 * @author zhousen
 * @date 2021/03/30 10:09
 **/
@Controller
@RequestMapping("/redis/redis" )
public class RedisManageController {

    private String prefix = "qidao/redis/redis" ;

    @Autowired
    private IRedisManageService redisManageService;

    @RequiresPermissions("redis:redis:view" )
    @GetMapping()
    public String redisView() {
        return prefix + "/redis" ;
    }

    /**
     * @Author zhousen
     * @Description redis 中的全部key
     * @Date 2021/03/30 10:11
     * @return void
     **/
    @RequiresPermissions("redis:redis:keyAll" )
    @PostMapping("/keyAll" )
    @ResponseBody
    public List<String > keyAll(){
       return redisManageService.keyAll();
    }

    /**
     * @Author zhousen
     * @Description redis 模糊查询 key
     * @Date 2021/03/30 10:11
     * @return void
     **/
    @RequiresPermissions("redis:redis:queryKeys" )
    @PostMapping("/queryKeys" )
    @ResponseBody
    public List<String > queryKeys(String key){
        return redisManageService.queryKeys(key);
    }

    /**
     * @Author zhousen
     * @Description 查询值的详细信息
     * @Date 2021/03/30 13:50
     * @param key
     * @return com.qidao.qidao.redis.redis.domain.RedisInfoRsp
     **/
    @RequiresPermissions("redis:redis:getInfoByKey" )
    @PostMapping("/getInfoByKey" )
    @ResponseBody
    public RedisInfoRsp getInfoByKey(String key){
        return redisManageService.getInfoByKey(key);
    }

   /**
    * @Author zhousen
    * @Description 设置过期时间
    * @Date 2021/03/30 13:55
    * @param key
    * @param second
    * @return boolean
    **/
    @RequiresPermissions("redis:redis:setTTL" )
    @PostMapping("/setTTL" )
    @ResponseBody
    public boolean setTTL(String key,Integer second){
        return redisManageService.setTTL(key,second);
    }

    /**
     * @Author zhousen
     * @Description 删除缓存
     * @Date 2021/03/30 13:55
     * @param key
     * @return boolean
     **/
    @RequiresPermissions("redis:redis:delete" )
    @PostMapping("/delete" )
    @ResponseBody
    public boolean delete(String key){
        return redisManageService.delete(key);
    }
}
