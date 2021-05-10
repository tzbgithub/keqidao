package com.qidao.qidao.equipment.equipment.domain;

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
public class AchievementEquipment {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte delFlag;

    private String url;

    private Long organizationId;

    private Long memberId;

    private Integer type;

    private Long maturity;

    private String title;

    private String video;

    private String thumb;

    private String imgs;

    private String summary;

    private Integer verifyStatus;

    private String verifyReason;

    private Long verifyUserId;

    private Long cooperationType;

    private String content;

    public enum Column {
        id("id", "id", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false),
        updateBy("update_by", "updateBy", "BIGINT", false),
        delFlag("del_flag", "delFlag", "TINYINT", false),
        url("url", "url", "VARCHAR", false),
        organizationId("organization_id", "organizationId", "BIGINT", false),
        memberId("member_id", "memberId", "BIGINT", false),
        type("type", "type", "INTEGER", false),
        maturity("maturity", "maturity", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        video("video", "video", "VARCHAR", false),
        thumb("thumb", "thumb", "VARCHAR", false),
        imgs("imgs", "imgs", "VARCHAR", false),
        summary("summary", "summary", "VARCHAR", false),
        verifyStatus("verify_status", "verifyStatus", "INTEGER", false),
        verifyReason("verify_reason", "verifyReason", "VARCHAR", false),
        verifyUserId("verify_user_id", "verifyUserId", "BIGINT", false),
        cooperationType("cooperation_type", "cooperationType", "BIGINT", false),
        content("content", "content", "LONGVARCHAR", false);

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