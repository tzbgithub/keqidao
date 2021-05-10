package com.qidao.qidao.dynamic.complaint.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.qidao.dynamic.complaint.domain.*;
import com.qidao.qidao.dynamic.complaint.mapper.CustomComplaintMapper;
import com.qidao.qidao.dynamic.complaint.service.CustomComplaintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  动态投诉管理功能实现
 * @author: liu Le
 * @create: 2021-01-20 13:26
 */
@Service
@Slf4j
public class CustomComplaintServiceImpl implements CustomComplaintService {
    @Resource
    private CustomComplaintMapper customComplaintMapper;

    /**
     * 通过数据库动态投诉列表构造界面显示的动态投诉列表
     *
     * @param complaint
     * @return 返回查询结果
     */
    @Override
    public List<ComplaintRes> selectComplaintList(Complaint complaint) {
        log.info("CustomComplaintServiceImpl -> selectComplaintList -> start -> complaint : {}", complaint);
        List<ComplaintDao> list = customComplaintMapper.selectComplaintList(complaint);
        List<ComplaintRes> comResList = new ArrayList<>();
        log.info("CustomComplaintServiceImpl -> selectComplaintList -> CollUtil.isNotEmpty(list) : {}", (CollUtil.isNotEmpty(list)));
        if(CollUtil.isNotEmpty(list)){
            for (ComplaintDao com : list){
               ComplaintRes complaintRes = new ComplaintRes();
                BeanUtils.copyProperties(com, complaintRes);
                comResList.add(complaintRes);
            }
        }
        log.info("CustomComplaintServiceImpl -> selectComplaintList -> end");
        return comResList;
    }

    @Override
    public ComplaintDetails getDescription(Long id) {
        ComplaintDetails res = new ComplaintDetails();
        ComplaintDetailsDao complaintDescription = customComplaintMapper.getComplaintDescription(id);
        if (complaintDescription == null){
            throw new BusinessException("动态已被删除");
        }
        BeanUtils.copyProperties(complaintDescription , res);
        String img = complaintDescription.getImg();
        if (StrUtil.isNotEmpty(img)){
            res.setImg(Arrays.asList(img.split(",")));
        }
        return res;
    }
}

