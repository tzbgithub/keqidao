package com.qidao.qidao.msg.msgRecord.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 用户-消息对象 msg_record
 * 
 * @author yqj
 * @date 2021-02-22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TMsgRecord extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 发送时间 */
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;
    /** 重复发送：第n次 ： 默认1 */
    @Excel(name = "重复发送：第n次 ： 默认1")
    private Integer sendNum;
    /** 状态 0-（发送成功）未读 1-（发送成功）已读 2-未发送状态  3-发送成功 4-发送失败 */
    @Excel(name = "状态 0-", readConverterExp = "发=送成功")
    private Integer status;
    /** 会员ID （接收) */
    @Excel(name = "会员ID ", readConverterExp = "会员ID （接收)")
    private Long memberId;
    /** 消息ID */
    @Excel(name = "消息ID")
    private Long msgId;
    /** 主键 */
    private Long id;
}
