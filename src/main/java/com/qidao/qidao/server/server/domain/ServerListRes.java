package com.qidao.qidao.server.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerListRes {

    /**
     * 主键
     */
    private Long id;

    /**
     *标题
     */
    private String title;

    /**
     *发布时间
     */
    private String createTime;

    /**
     *发布人
     */
    private String memberName;

    /**
     *需求领域
     */
    private String specArea;

    /**
     *状态
     */
    private Integer status;

}
