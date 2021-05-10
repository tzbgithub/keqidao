package com.qidao.qidao.msg.msgMenu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgMenuFather {

    private Long id;

    private String name;

    private Long pid;

    private List<MsgMenuSon> sons;

}
