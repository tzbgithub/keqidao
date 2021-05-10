package com.qidao.qidao.dynamic.domain;

import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicPageReq extends BaseEntity {

    private String memberName;

    private String title;

    private Integer status;

    private String startTime;

    private String endTime;
}
