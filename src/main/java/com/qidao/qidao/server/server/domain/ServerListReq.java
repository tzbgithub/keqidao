package com.qidao.qidao.server.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerListReq {


    /**
     *标题
     */
    private String title;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     *需求领域
     */
    private Long specAreaId;

    /**
     *状态
     */
    private Integer status;

}
