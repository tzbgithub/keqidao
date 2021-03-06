package com.qidao.qidao.msg.msg.domain;

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
public class Msg {
    private Long id;

    private Long menuId;

    private String title;

    private Integer type;

    private Integer status;

    private LocalDateTime expireTime;

    private LocalDateTime pushTime;

    private Integer sequence;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte delFlag;

    private Integer receiveType;

    private Integer maxNum;

    private Integer contentType;

    private Integer titleType;

    private String content;

    public enum Column {
        id("id", "id", "BIGINT", false),
        menuId("menu_id", "menuId", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        type("type", "type", "INTEGER", false),
        status("status", "status", "INTEGER", false),
        expireTime("expire_time", "expireTime", "TIMESTAMP", false),
        pushTime("push_time", "pushTime", "TIMESTAMP", false),
        sequence("sequence", "sequence", "INTEGER", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false),
        updateBy("update_by", "updateBy", "BIGINT", false),
        delFlag("del_flag", "delFlag", "TINYINT", false),
        receiveType("receive_type", "receiveType", "INTEGER", false),
        maxNum("max_num", "maxNum", "INTEGER", false),
        contentType("content_type", "contentType", "INTEGER", false),
        titleType("title_type", "titleType", "INTEGER", false),
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