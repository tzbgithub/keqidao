package com.qidao.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationPageReq {

    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "pageSize", value = "每页条数")
    private Integer pageSize;
    @ApiModelProperty(name = "pageNum", value = "当前页")
    private Integer pageNum;
}
