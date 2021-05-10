package com.qidao.qidao.msg.msgMenu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgMenuSon {

    private Long id;

    private Long pid;

    private String name;

}
