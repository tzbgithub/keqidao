package com.qidao.qidao.dynamic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicInsertReq {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 热门
     */
    private Integer hot;

    /**
     * 技术成熟度
     */
    private Long maturity;

    /**
     * 合作类型
     */
    private Long cooperation;

    /**
     * 频道
     */
    private Long channel;

    /**
     * 图片
     */
    private String img;

    /**
     * 视频
     */
    private String video;

    /**
     * 封面图
     */
    private String thumb;

    /**
     * 链接
     */
    private String url;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 标签
     */
    private String labels;

    /**
     * 发布类型
     */
    private String articles;

    /**
     * 运营人员ID
     */
    private Long salesmanId;


}
