package com.qidao.qidao.wx.message.dto;

import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateListDto extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String primary_industry;
    private String deputy_industry;
    private String content;
    private String example;

}
