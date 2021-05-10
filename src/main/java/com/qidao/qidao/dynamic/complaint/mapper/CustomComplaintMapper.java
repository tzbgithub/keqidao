package com.qidao.qidao.dynamic.complaint.mapper;

import com.qidao.qidao.dynamic.complaint.domain.Complaint;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintDao;
import com.qidao.qidao.dynamic.complaint.domain.ComplaintDetailsDao;

import java.util.List;

/**
 * @author: xinfeng
 * @create: 2021-03-02 10:21
 */
public interface CustomComplaintMapper {
    /**
     * 查询动态投诉列表
     *
     * @param complaint ：查询条件
     * @return 查询结果
     */
    List<ComplaintDao> selectComplaintList(Complaint complaint);

    ComplaintDetailsDao getComplaintDescription(Long complaintId);
}
