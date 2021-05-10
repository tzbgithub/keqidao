package com.qidao.qidao.channel.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelListRes {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd T HH:mm:ss")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd T HH:mm:ss")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 最后修改人
     */
    private String reviserName;

    /**
     * 逻辑删除
     */
    private Byte delFlag;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序值越大越前
     */
    private Integer sequence;

}
