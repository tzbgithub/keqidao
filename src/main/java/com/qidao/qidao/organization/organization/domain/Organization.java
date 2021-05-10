package com.qidao.qidao.organization.organization.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte delFlag;

    private Integer type;

    /** 审核原因 */
    @Excel(name = "审核原因")
    private String verifyReason;
    /** 0-未审核 1-审核中 2-审核后    入驻审核 */
    @Excel(name = "0-未审核 1-审核中 2-审核后    入驻审核")
    private Long verifyStatus;
    /** vip结束时间 */
    @Excel(name = "vip结束时间")
    private LocalDateTime vipEndTime;
    /** vip开始时间 */
    @Excel(name = "vip开始时间")
    private LocalDateTime vipStartTime;
    /** 0-未认证 1-认证中 2-已认证    企业认证 */
    @Excel(name = "0-未认证 1-认证中 2-已认证    企业认证")
    private Long status;
    /** 技术规模id 关联select_config */
    @Excel(name = "技术规模id 关联select_config")
    private Long techScaleId;
    /** 详细地址 */
    @Excel(name = "详细地址")
    private String addressDetail;
    /** 地址区名称 */
    @Excel(name = "地址区名称")
    private String addressAreaName;
    /** 地址区ID */
    @Excel(name = "地址区ID")
    private Long addressAreaId;
    /** 地址市名称 */
    @Excel(name = "地址市名称")
    private String addressCityName;
    /** 地址市id */
    @Excel(name = "地址市id")
    private Long addressCityId;
    /** 地址省名称 */
    @Excel(name = "地址省名称")
    private String addressProvinceName;
    /** 地址省ID */
    @Excel(name = "地址省ID")
    private Long addressProvinceId;
    /** 证书/导师 资格证图片 */
    @Excel(name = "证书/导师 资格证图片")
    private String qualifications;
    /** 执照/铭牌 路径 */
    @Excel(name = "执照/铭牌 路径")
    private String license;
    /** 注册时间 */
    @Excel(name = "注册时间")
    private LocalDateTime signTime;
    /** 规模id 关联select_config */
    @Excel(name = "规模id 关联select_config")
    private Long scaleId;
    /** 经费id 关联select_config */
    @Excel(name = "经费id 关联select_config")
    private String fundsId;
    /** 所属行业备注 */
    @Excel(name = "所属行业备注")
    private String industryRemark;
    /** 所属行业id 关联select_config */
    @Excel(name = "所属行业id 关联select_config")
    private Long industryId;
    /** 简介 */
    @Excel(name = "简介")
    private String summary;
    /** 名称 */
    @Excel(name = "名称")
    private String name;
    /** 空间背景图 */
    @Excel(name = "空间背景图")
    private String backendImage;
    /** 负责人用户ID */
    @Excel(name = "负责人用户ID")
    private Long responsibleMemberId;

    private String belong;

    private Long salesmanId;

    private String isFlag;

    private Long verifyUserId;

    private Long recheckId;

    private LocalDateTime verifyTime;

    public enum Column {
        id("id", "id", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false),
        updateBy("update_by", "updateBy", "BIGINT", false),
        delFlag("del_flag", "delFlag", "TINYINT", false),
        type("type", "type", "INTEGER", false),
        responsibleMemberId("responsible_member_id", "responsibleMemberId", "BIGINT", false),
        backendImage("backend_image", "backendImage", "VARCHAR", false),
        name("name", "name", "VARCHAR", false),
        summary("summary", "summary", "VARCHAR", false),
        industryId("industry_id", "industryId", "BIGINT", false),
        industryRemark("industry_remark", "industryRemark", "VARCHAR", false),
        fundsId("funds_id", "fundsId", "VARCHAR", false),
        scaleId("scale_id", "scaleId", "BIGINT", false),
        signTime("sign_time", "signTime", "TIMESTAMP", false),
        license("license", "license", "VARCHAR", false),
        qualifications("qualifications", "qualifications", "VARCHAR", false),
        addressProvinceId("address_province_id", "addressProvinceId", "VARCHAR", false),
        addressProvinceName("address_province_name", "addressProvinceName", "VARCHAR", false),
        addressCityId("address_city_id", "addressCityId", "VARCHAR", false),
        addressCityName("address_city_name", "addressCityName", "VARCHAR", false),
        addressAreaId("address_area_id", "addressAreaId", "VARCHAR", false),
        addressAreaName("address_area_name", "addressAreaName", "VARCHAR", false),
        addressDetail("address_detail", "addressDetail", "VARCHAR", false),
        techScaleId("tech_scale_id", "techScaleId", "BIGINT", false),
        status("status", "status", "INTEGER", false),
        vipStartTime("vip_start_time", "vipStartTime", "TIMESTAMP", false),
        vipEndTime("vip_end_time", "vipEndTime", "TIMESTAMP", false),
        verifyStatus("verify_status", "verifyStatus", "INTEGER", false),
        verifyReason("verify_reason", "verifyReason", "VARCHAR", false),
        belong("belong", "belong", "VARCHAR", false),
        salesmanId("salesman_id", "salesmanId", "BIGINT", false),
        isFlag("is_flag", "isFlag", "VARCHAR", false),
        verifyUserId("verify_user_id", "verifyUserId", "BIGINT", false),
        recheckId("recheck_id", "recheckId", "BIGINT", false),
        verifyTime("verify_time", "verifyTime", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}