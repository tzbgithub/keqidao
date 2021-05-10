package com.qidao.qidao.contract.contract.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinfeng
 * @create: 2021-03-02 17:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractDetailRes {
    /** 主键 */
    private Long id;
    /** 合同名称 */
    private String serverTitle;
    /** 合同到期时间 */
    private String endTime;
    /** 合同开始时间 */
    private String beginTime;
    /** 签订时间 */
    private String signTime;
    /** 合同确认时间 */
    private String confirmTime;
    /** 合同编号 */
    private String noNumber;
    /** 承接方 */
    private String memberNamePartB;
    /** 需求方 */
    private String memberNamePartyA;
    /** 状态 */
    private Integer status;
    /** 甲方组织名称 */
    private String OrganizationNamePartA;
    /** 乙方组织名称 */
    private String OrganizationNamePartB;
    /** 签订地址省份 */
    private String signAddressProvinceName;
    /** 签订地址市 */
    private String signAddressCityName;
    /** 签订地区 */
    private String signAddressAreaName;
    /** 创建时间 */
    private String createTime;
}
