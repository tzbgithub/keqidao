package com.qidao.qidao.config.other.domain;

import lombok.Data;

/**
 * 首页昨日数据统计封装对象
 */
@Data
public class IndexCountRes {
    /**
     * 昨日新增用户
     */
    private Integer yesterdayNewUser;
    /**
     * 昨日新增企业
     */
    private Integer yesterdayNewEnterprise;
    /**
     * 昨日新增实验室
     */
    private Integer yesterdayNewLab;
    /**
     * 昨日新增动态
     */
    private Integer yesterdayNewDynamic;
    /**
     * 昨日新增需求
     */
    private Integer yesterdayNewServer;
    /**
     * 昨日新增合同
     */
    private Integer yesterdayNewContract;
}
