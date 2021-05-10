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
public class TemplateSendDto extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 模板id
     */
    private String id;
    /**
     * 模板跳转的链接
     */
    private String url;

    private String firstValue;
    private String firstColor;
    private String keyword1Value;
    private String keyword1Color;
    private String keyword2Value;
    private String keyword2Color;
    private String keyword3Value;
    private String keyword3Color;
    private String remarkValue;
    private String remarkColor;


}
