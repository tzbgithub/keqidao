package com.qidao.qidao.canal.canal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CanalAddReq {

    private String name;

    private String version;

    private String downPath;

    private Integer delFlag;

}
