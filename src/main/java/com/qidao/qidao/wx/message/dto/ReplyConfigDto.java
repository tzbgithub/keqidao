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
public class ReplyConfigDto extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String replyToText;


}
