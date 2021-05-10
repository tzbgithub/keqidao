package com.qidao.qidao.dynamic.service;

import com.qidao.qidao.dynamic.domain.*;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomDynamicService {

    List<DynamicPageRes> getDynamic(DynamicPageReq req);

    DynamicDetails getDynamicById(Long id);

    List<DynamicChannel> getChannel();

    /**
     * 通过审核
     * @param req
     * @return
     */
    int verifyDynamicPass(VerifyReq req);

    /**
     * 未通过审核
     * @param id
     * @return
     */
    int verifyDynamicFailed(Long id);

    /**
     * 通过核准(上架)
     * @param req
     * @return
     */
    int approvalDynamicPass(VerifyReq req);

    /**
     * 未通过核准（返回待审核状态）
     * @param id
     * @return
     */
    int approvalDynamicFailed(Long id);

    int checkPending(Long id );

    int create(DynamicInsertReq req);

    int updateChannel(VerifyReq req);

    List<MemberInfo> getMember(String name);

    int allData();

    int getYesterdayData();

    int verifyData();

}
