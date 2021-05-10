package com.qidao.qidao.dynamic.complaint.service;

import com.qidao.qidao.dynamic.complaint.domain.Complaint;

import java.util.List;

/**
 * 动态投诉Service接口
 *
 * @author autuan
 * @date 2021-01-19
 */
public interface IComplaintService {
    /**
     * 查询动态投诉
     *
     * @param id 动态投诉ID
     * @return 动态投诉
     */
    Complaint selectComplaintById(Long id);

    /**
     * 查询动态投诉列表
     *
     * @param complaint 动态投诉
     * @return 动态投诉集合
     */
    List<Complaint> selectComplaintList(Complaint complaint);

    /**
     * 新增动态投诉
     *
     * @param complaint 动态投诉
     * @return 结果
     */
    int insertComplaint(Complaint complaint);

    /**
     * 修改动态投诉
     *
     * @param complaint 动态投诉
     * @return 结果
     */
    int updateComplaint(Complaint complaint);

    /**
     * 批量删除动态投诉
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteComplaintByIds(String ids);

    /**
     * 删除动态投诉信息
     *
     * @param id 动态投诉ID
     * @return 结果
     */
    int deleteComplaintById(Long id);

    int logicDelByIds(String ids);
}
