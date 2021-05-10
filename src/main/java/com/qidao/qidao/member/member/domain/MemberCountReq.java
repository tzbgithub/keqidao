package com.qidao.qidao.member.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCountReq {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
