package com.qidao.qidao.member.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeMemberReq {

    private Long id;

    private String name;

}
