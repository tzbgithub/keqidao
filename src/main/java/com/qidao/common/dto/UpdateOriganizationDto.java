package com.qidao.common.dto;

import com.sun.jna.platform.unix.solaris.LibKstat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOriganizationDto {
    @NotNull(message = "名称不能为空")
    @ApiModelProperty(name = "name", value = "实验室名称", required = true,example ="测试数据")
    private String name;
    @NotNull(message = "组织标识不能为空")
    @ApiModelProperty(name = "id", value = "组织机构标识", required = true,example ="133547444731905")
    private Long id;
    @NotNull(message = "操作人不能为空")
    @ApiModelProperty(name = "operator", value = "操作人(不变更实验室负责人无需传入变更负责人标识)", required = true,example ="133547444731905")
    private Long operator;
    @NotNull(message = "经费不能为空")
    @ApiModelProperty(name = "fundsId", value = "经费", required = true,example ="1000")
    private String fundsId;
    @NotNull(message = "规模不能为空")
    @ApiModelProperty(name = "scaleId", value = "规模id", required = true,example = "100")
    private Long scaleId;
    @ApiModelProperty(name = "addressProvinceId", value = "地址省ID", required = false,example = "1")
    private String addressProvinceId;
    @ApiModelProperty(name = "addressProvinceName", value = "地址省名称", required = false,example = "上海")
    private String addressProvinceName;
    @ApiModelProperty(name = "addressCityId", value = "地址市id", required = false,example = "1")
    private String addressCityId;
    @ApiModelProperty(name = "addressCityName", value = "地址市名称", required = false,example = "上海")
    private String addressCityName;
    @ApiModelProperty(name = "addressAreaId", value = "地址区ID", required = false,example = "1")
    private String addressAreaId;
    @ApiModelProperty(name = "addressAreaName", value = "地址区名称", required = false,example = "上海")
    private String addressAreaName;
    @NotNull(message = "所属单位不能为空")
    @ApiModelProperty(name = "belong", value = "所属单位", required = true,example = "东华大学")
    String belong;
    @Size(max = 150,message = "不得超过150个字")
    @NotNull(message = "简介不能为空")
    @ApiModelProperty(name = "summary", value = "简介", required = true,example = "东华大学坐落于松江")
    String summary;

}
