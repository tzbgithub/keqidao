package com.qidao.qidao.server.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerDescriptionRes {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 需求领域
     */
    private String specArea;

    /**
     * 研发经费
     */
    private String specAmount;

    /**
     * 地址
     */
    private String address;

    /**
     * 期望解决时间
     */
    private String  solutionTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 描述文件地址
     */
    private String url;

}
