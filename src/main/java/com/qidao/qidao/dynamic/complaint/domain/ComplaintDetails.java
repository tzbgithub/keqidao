package com.qidao.qidao.dynamic.complaint.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintDetails {

    private String title;

    private String url;

    private List<String> img;

    private String thumb;

    private String video;

    private String publishTime;

    private String memberName;

    private String content;

    private Integer verifyStatus;

    private String channel;

    private String reason;

    private String complaintTime;

    private String complaintName;

    private Long complaintId;

}
