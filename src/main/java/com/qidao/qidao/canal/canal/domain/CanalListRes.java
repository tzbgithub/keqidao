package com.qidao.qidao.canal.canal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CanalListRes {

    private Long id;

    private Integer delFlag;

    private String name;

    private String version;

    private String createBy;

    private LocalDateTime createTime;

}
