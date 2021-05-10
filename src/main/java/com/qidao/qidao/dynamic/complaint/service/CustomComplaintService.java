package com.qidao.qidao.dynamic.complaint.service;

import com.qidao.qidao.dynamic.complaint.domain.Complaint;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintDetails;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintRes;
import java.util.List;

/**
 * @author: liu Le
 * @create: 2021-01-20 13:25
 */
public interface CustomComplaintService {

    /**
     * 查询动态投诉列表
     *
     * @param complaint
     * @return 返回查询结果
     */
    List<ComplaintRes> selectComplaintList(Complaint complaint);

    ComplaintDetails getDescription(Long id);
}
