package com.qidao.qidao.dynamic.mapper;

import com.qidao.qidao.dynamic.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CustomDynamicMapper {

    List<CustomDynamic> getDynamic(DynamicPageReq req);

    /**
     * 审核通过
     * @param id
     * @param userId
     * @return
     */
    int verifyDynamicPass(Long id , Long userId);

    /**
     * 审核撤销
     * @param id
     * @param userId
     * @return
     */
    int verifyDynamicFailed(Long id, Long userId);

    /**
     * 核准通过（上架）
     * @param id
     * @param userId
     * @return
     */
    int approvalDynamicPass(Long id, Long userId);

    /**
     * 核准撤销（返回待审核状态）
     * @param id
     * @param userId
     * @return
     */
    int approvalDynamicFailed(Long id, Long userId);

    DynamicById getDynamicById(Long id);

    List<DynamicChannel> getChannel();

    void deleteChannel(Long dynamicId);

    int insertChannel(ChannelDynamicAdd add);

    int checkPending(Long id , Long userId);

    List<MemberInfo> getMember(@Param("name") String name);

    List<CustomDynamic> getDynamicByIds(List<Long> ids);

    int allData();

    int getYesterdayData(LocalDateTime startTime , LocalDateTime endTime);

    int verifyData();
}
