package com.qidao.common.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationRep {
    @ApiModelProperty(name = "id", value = "主键")
    private Long id;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "summary", value = "简介")
    private String summary;
    @ApiModelProperty(name = "industryId", value = "所属行业id")
    private Long industryId;
    @ApiModelProperty(name = "industryRemark", value = "所属行业简介")
    private String industryRemark;
    @ApiModelProperty(name = "fundsId", value = "经费id")
    private String fundsId;
    @ApiModelProperty(name = "scaleId", value = "规模id")
    private Long scaleId;
    @ApiModelProperty(name = "signTime", value = "注册时间")
    private LocalDateTime signTime;
    @ApiModelProperty(name = "license", value = "执照/铭牌 路径")
    private String license;
    @ApiModelProperty(name = "qualifications", value = "证书/导师 资格证图片")
    private List<String> qualifications;
    @ApiModelProperty(name = "addressProvinceId", value = "地址省ID")
    private String addressProvinceId;
    @ApiModelProperty(name = "addressProvinceName", value = "地址省名称")
    private String addressProvinceName;
    @ApiModelProperty(name = "addressCityId", value = "地址市id")
    private String addressCityId;
    @ApiModelProperty(name = "addressCityName", value = "地址市名称")
    private String addressCityName;
    @ApiModelProperty(name = "addressAreaId", value = "地址区ID")
    private String addressAreaId;
    @ApiModelProperty(name = "addressAreaName", value = "地址区名称")
    private String addressAreaName;
    @ApiModelProperty(name = "techScaleId", value = "技术规模id ")
    private Long techScaleId;
    @ApiModelProperty(name = "verifyStatus", value = "0-未审核 1-审核中 2-审核后")
    private Integer verifyStatus;
    @ApiModelProperty(name = "phone", value = "手机号")
    String phone;



}
