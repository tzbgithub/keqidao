package com.qidao.qidao.contract.contract.domain;

import com.qidao.framework.aspectj.lang.annotation.Excel;
import com.qidao.framework.web.domain.BaseEntity;
import lombok.Builder;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 合同对象 contract
 * 
 * @author autuan
 * @date 2021-03-02
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 需求-标题名称 */
    @Excel(name = "需求-标题名称")
    private String serverTitle;
    /** 合同确认时间 */
    @Excel(name = "合同确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmTime;
    /** 签订地址区名称 */
    @Excel(name = "签订地址区名称")
    private String signAddressAreaName;
    /** 签订地址区ID */
    @Excel(name = "签订地址区ID")
    private Integer signAddressAreaId;
    /** 签订地址市名称 */
    @Excel(name = "签订地址市名称")
    private String signAddressCityName;
    /** 签订地址市id */
    @Excel(name = "签订地址市id")
    private Integer signAddressCityId;
    /** 签订地址省名称 */
    @Excel(name = "签订地址省名称")
    private String signAddressProvinceName;
    /** qd_address_province 表主键  签订地址省ID */
    @Excel(name = "qd_address_province 表主键  签订地址省ID")
    private Integer signAddressProvinceId;
    /** 合同状态：0-草稿；1-已确定合同(进度已确定)；2-已签订合同(合同生效)；3-进度已完成 */
    @Excel(name = "合同状态：0-草稿；1-已确定合同(进度已确定)；2-已签订合同(合同生效)；3-进度已完成")
    private Integer status;
    /** 合同有效结束时间 */
    @Excel(name = "合同有效结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;
    /** 合同有效开始时间 */
    @Excel(name = "合同有效开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;
    /** 签订时间 */
    @Excel(name = "签订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signTime;
    /** 登记编号 */
    @Excel(name = "登记编号")
    private String no;
    /** 乙方用户ID */
    @Excel(name = "乙方用户ID")
    private Long memberIdPartB;
    /** 甲方用户ID */
    @Excel(name = "甲方用户ID")
    private Long memberIdPartyA;
    /** 乙方组织ID */
    @Excel(name = "乙方组织ID")
    private Long organizationIdPartyB;
    /** 甲方组织ID */
    @Excel(name = "甲方组织ID")
    private Long organizationIdPartyA;
    /** 服务需求ID */
    @Excel(name = "服务需求ID")
    private Long serverId;
    /** 主键 */
    private Long id;
}
