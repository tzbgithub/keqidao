package com.qidao.qidao.dynamic.complaint.service.impl;

import java.util.List;

import com.qidao.common.utils.security.ShiroUtils;

import com.qidao.project.system.user.domain.User;
import com.qidao.qidao.member.member.mapper.TMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.qidao.qidao.dynamic.complaint. mapper.ComplaintMapper;
import com.qidao.qidao.dynamic.complaint. domain.Complaint;
import com.qidao.qidao.dynamic.complaint. service.IComplaintService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 动态投诉Service业务层处理
 *
 * @author autuan
 * @date 2021-01-19
 */
@Service
@Slf4j
public class ComplaintServiceImpl implements IComplaintService {
    @Resource
    private ComplaintMapper complaintMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    @Resource
    private TMemberMapper TMemberMapper;

    /**
     * 查询动态投诉
     *
     * @param id 动态投诉ID
     * @return 动态投诉
     */
    @Override
    public Complaint selectComplaintById(Long id) {
        log.info("ComplaintServiceImpl -> selectComplaintById -> start -> id : {}", id);
        log.info("ComplaintServiceImpl -> selectComplaintById -> end");
        return complaintMapper.selectComplaintById(id);
    }

    /**
     * 查询动态投诉列表
     *
     * @param complaint 动态投诉
     * @return 动态投诉
     */
    @Override
    public List<Complaint> selectComplaintList(Complaint complaint) {
        log.info("ComplaintServiceImpl -> selectComplaintList -> start -> complaint : {}", complaint);
        log.info("ComplaintServiceImpl -> selectComplaintList -> end");
        return complaintMapper.selectComplaintList(complaint);
    }

    /**
     * 新增动态投诉
     *
     * @param complaint 动态投诉
     * @return 结果
     */
    @Override
    public int insertComplaint(Complaint complaint) {
        log.info("ComplaintServiceImpl -> insertComplaint -> start -> complaint : {}", complaint);
        complaint.setId(snowflakeIdWorker.nextId());
        complaint.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        log.info("ComplaintServiceImpl -> insertComplaint -> end");
        return complaintMapper.insertComplaint(complaint);
    }

    /**
     * 修改动态投诉
     *
     * @param complaint 动态投诉
     * @return 结果
     */
    @Override
    public int updateComplaint(Complaint complaint) {
        log.info("ComplaintServiceImpl -> updateComplaint -> start -> complaint : {}", complaint);
        complaint.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        User sysUser = ShiroUtils.getSysUser();
        complaint.setReplyUserId(sysUser.getUserId());
        complaint.setReplyUserName(sysUser.getUserName());
        log.info("ComplaintServiceImpl -> updateComplaint -> end");
        return complaintMapper.updateComplaint(complaint);
    }

    /**
     * 删除动态投诉对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteComplaintByIds(String ids) {
        log.info("ComplaintServiceImpl -> deleteComplaintByIds -> start -> ids : {}", ids);
        log.info("ComplaintServiceImpl -> deleteComplaintByIds -> end");
        return complaintMapper.deleteComplaintByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态投诉信息
     *
     * @param id 动态投诉ID
     * @return 结果
     */
    @Override
    public int deleteComplaintById(Long id) {
        log.info("ComplaintServiceImpl -> deleteComplaintById -> start -> id : {}", id);
        log.info("ComplaintServiceImpl -> deleteComplaintById -> end");
        return complaintMapper.deleteComplaintById(id);
    }

    /**
     * 逻辑删除动态投诉对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        log.info("ComplaintServiceImpl -> logicDelByIds -> start -> ids : {}", ids);
        log.info("ComplaintServiceImpl -> logicDelByIds -> end");
        return complaintMapper.logicDelByIds(Convert.toStrArray(ids));
    }
}
