package com.qidao.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "object")
public class OrganizationDto implements Serializable {

   /* @ApiModelProperty(name = "backendImage", value = "空间背景图", required = false)
    private String backendImage;*/
    @ApiModelProperty(name = "name", value = "名称", required = true,example = "张三")
    private String name;
    @ApiModelProperty(name = "summary", value = "简介", required = true,example ="早上")
    private String summary;
    @ApiModelProperty(name = "industryId", value = "所属行业id", required = true,example ="1")
    private Long industryId;
    @ApiModelProperty(name = "industryRemark", value = "所属行业简介", required = true,example = "干活的")
    private String industryRemark;
    @ApiModelProperty(name = "fundsId", value = "经费id", required = true,example ="1000")
    private String fundsId;
    @ApiModelProperty(name = "scaleId", value = "规模id", required = true,example = "100")
    private Long scaleId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "signTime", value = "注册时间", required = true,example = "2020-12-15 14:15:17")
    private LocalDateTime signTime;
    @ApiModelProperty(name = "license", value = "执照/铭牌 路径", required = false)
    private String license;
    @ApiModelProperty(name = "qualifications", value = "证书/导师 资格证图片", required = false)
    private List<String> qualifications;
    @ApiModelProperty(name = "addressProvinceId", value = "地址省ID", required = true,example = "1")
    private String addressProvinceId;
    @ApiModelProperty(name = "addressProvinceName", value = "地址省名称", required = true,example = "1")
    private String addressProvinceName;
    @ApiModelProperty(name = "addressCityId", value = "地址市id", required = true,example = "1")
    private String addressCityId;
    @ApiModelProperty(name = "addressCityName", value = "地址市名称", required = true,example = "上海")
    private String addressCityName;
    @ApiModelProperty(name = "addressAreaId", value = "地址区ID", required = true,example = "1")
    private String addressAreaId;
    @ApiModelProperty(name = "addressAreaName", value = "地址区名称", required = true,example = "上号")
    private String addressAreaName;
    @ApiModelProperty(name = "techScaleId", value = "技术规模id ", required = true,example = "1")
    private Long techScaleId;
    @ApiModelProperty(name = "verifyStatus", value = "0-未审核 1-审核中 2-审核后", required = false)
    private Integer verifyStatus;
    @ApiModelProperty(name = "phone", value = "手机号", required = true,example = "18722390324")
    @Pattern(regexp ="^((1[0-9]))\\d{9}$",message = "手机号格式不匹配")
    String phone;
    @ApiModelProperty(name = "skillService", value = "服务方向 传入下拉标识", required = false,example = "[1,2,3]")
    Long[] skillService;
    @ApiModelProperty(name = "label", value = "标签", required = false,example = "['人工智能','机器人']")
    String[] label;
    @ApiModelProperty(name = "email", value = "邮箱", required = true,example = "sdfsdfs@qq.com")
    String email;
    @ApiModelProperty(name = "createMan", value = "销售人名字(销售录入实验室入口必传)", required = false,example = "华盛顿")
    String createMan;
    @ApiModelProperty(name = "belong", value = "所属单位", required = false,example = "东华大学")
    String belong;
    @ApiModelProperty(name = "openId", value = "微信标识", required = false,example = "sdfsfsfd")
    String openId;
    @ApiModelProperty(name = "positionId", value = "职位标识", required = false,example = "1")
    Long positionId;
    @ApiModelProperty(name = "educationId", value = "学历标识", required = false,example = "1")
    Long educationId;
    @ApiModelProperty(name = "roleId", value = "是否是行政人员", required = false,example = "0")
    Integer roleId;
    @ApiModelProperty(name = "type", value = "类型", required = true,example = "0")
    Integer type;


}
