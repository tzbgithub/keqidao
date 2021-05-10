package com.qidao.qidao.wx.message.dto;

import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageSendDto extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String text;

//    private String img;

    private String img;

}
