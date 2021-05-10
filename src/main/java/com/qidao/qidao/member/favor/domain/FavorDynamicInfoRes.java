package com.qidao.qidao.member.favor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavorDynamicInfoRes {

    private Long id;

    private Long memberId;

    private LocalDateTime publishTime;

    private String title;

    private Integer commentNum;

    private Integer likeNum;

    private String img;

    private String summary;

    private List<DynamicLabel> labels;

}
