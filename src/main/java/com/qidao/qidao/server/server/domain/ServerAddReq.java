package com.qidao.qidao.server.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerAddReq {

    /**
     * 标题
     */
    private String title;

    /**
     * 需求领域
     */
    private Long specAreaId;

    /**
     * 发布人
     */
    private Long memberIdPartyA;

    /**
     * 研发经费
     */
    private Long specAmountId;

    /**
     * 地址省编码
     */
    private Integer addressProvinceId;

    /**
     * 地址省名字
     */
    private String addressProvinceName;

    /**
     * 地址市编码
     */
    private Integer addressCityId;

    /**
     * 地址市名字
     */
    private String addressCityName;

    /**
     * 地址县编码
     */
    private Integer addressAreaId;

    /**
     * 地址县名字
     */
    private String addressAreaName;

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
