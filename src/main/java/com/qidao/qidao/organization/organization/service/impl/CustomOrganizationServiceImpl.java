package com.qidao.qidao.organization.organization.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.qidao.common.dto.UpdateOriganizationDto;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.exception.BusinessException;
import com.qidao.common.utils.Md5Utils;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.verify.VerifyMatch;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.qidao.label.label.domain.Label;
import com.qidao.qidao.label.label.domain.LabelExample;
import com.qidao.qidao.label.label.mapper.LabelMapper;
import com.qidao.qidao.link.linkLabel.domain.LinkLabel;
import com.qidao.qidao.link.linkLabel.domain.LinkSelect;
import com.qidao.qidao.link.linkLabel.mapper.LinkLabelMapper;
import com.qidao.qidao.link.linkLabel.mapper.LinkSelectMapper;
import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.domain.MemberExample;
import com.qidao.qidao.member.member.mapper.MemberMapper;
import com.qidao.qidao.organization.organization.domain.*;
import com.qidao.qidao.member.member.mapper.CustomMemberMapper;
import com.qidao.qidao.organization.organization.domain.enums.OrganizationEnum;
import com.qidao.qidao.organization.organization.domain.enums.OrganizationErrorEnum;
import com.qidao.qidao.organization.organization.mapper.CustomOrganizationMapper;
import com.qidao.qidao.organization.organization.mapper.OrganizationMapper;
import com.qidao.qidao.organization.organization.service.CustomOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j
public class CustomOrganizationServiceImpl implements CustomOrganizationService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    CustomMemberMapper customMemberMapper;
    @Autowired
    CustomOrganizationMapper customOrganizationMapper;
    @Autowired
    SnowflakeIdWorker53 snowflakeIdWorker53;
    @Autowired
    LinkLabelMapper linkLabelMapper;
    @Autowired
    LabelMapper labelMapper;
    @Autowired
    OrganizationMapper organizationMapper;

    @Resource
    private LinkSelectMapper linkSelectMapper;


   /* @Override
    public ResponseResult save(OrganizationDto organizationDto) {
        byte flag = 0;
        for (String match : organizationDto.getLabel()){
            boolean fa = VerifyMatch.containsAll(match);
            if(fa){
                return  new ResponseResult<Organization>("xxxxxx",null, "非法字符", LocalDateTime.now());
            }
        }
        log.info("--- OrganizationServiceImpl ---> save ----> params {}---",organizationDto);

        Member meb = customMemberMapper.findByPhone(organizationDto.getPhone());
        log.info("--- OrganizationServiceImpl ---> save -- 搜寻用户 ---");
        boolean f = (meb != null) && (meb.getOrganizationId() != null);
        log.info("--- OrganizationServiceImpl ---> save -- fg !=null ---");
        if(f){
            return  new ResponseResult<Organization>("xxxx",null, "已开通",LocalDateTime.now());
        }
        long organizationId = snowflakeIdWorker53.nextId();
        Organization entity = customOrganizationMapper.findByNameAndTypeAndBelong(organizationDto.getName(),0,organizationDto.getBelong());
        Organization organization = new Organization();
        long memberId = snowflakeIdWorker53.nextId();
                List<String> qualifications = organizationDto.getQualifications();
                if(qualifications.size()<=0){
                    return  new ResponseResult<Organization>("xxxx",null,
                            "图片参数不匹配",LocalDateTime.now());
                }
                StringBuffer stringBuffer = new StringBuffer();
                qualifications.stream().forEach(x->{
                    stringBuffer.append(x).append(",");
                });
                String substring = stringBuffer.substring(0, stringBuffer.lastIndexOf(","));
                organization.setQualifications(substring);
                log.info("--- OrganizationServiceImpl ---> save -- IndustryId --!=null ---");
                if(organizationDto.getIndustryId()==null){
                    return  new ResponseResult<Organization>("xxxx",null, "请选择行业",LocalDateTime.now());
                }
                log.info("--- OrganizationServiceImpl ---> save -- 组织 entity --!=null case [0] ---");
                organization.setQualifications(organization.getQualifications());
                log.info("--- OrganizationServiceImpl ---> save -- 下拉展示数据 标签 --!=null ---");
                if( organizationDto.getSkillService().length>0 && organizationDto.getLabel().length>0){
                    log.info("--- OrganizationServiceImpl ---> save -- 下拉展示数据 标签 --数量限制 ---");
                    if(organizationDto.getSkillService().length>3 || organizationDto.getLabel().length>5){
                        return  new ResponseResult<Organization>("xxxx",null, "您输入的科研方向过多，请适当精简",LocalDateTime.now());
                    }
                    log.info("--- OrganizationServiceImpl ---> save -- 循环传入标签 ---");
                    for (String la : organizationDto.getLabel()){
                        TLinkLabel linklb = new TLinkLabel();
                        LabelExample labelExample = new LabelExample();
                        labelExample.createCriteria().andValEqualTo(la);
                        Label lb = labelMapper.selectOneByExample(labelExample);
                        log.info("---- OrganizationServiceImpl ---> save --- 标签已经存在直接建立关系 ------");
                        if(lb!=null){
                            linklb.setDelFlag("0");
                            linklb.setId(snowflakeIdWorker53.nextId());
                            linklb.setType(4L);
                            linklb.setLabelId(lb.getId());
                            linklb.setSourceId(organizationId);
                            TLinkLabelMapper.insertLinkLabel(linklb);
                        }else {
                            log.info("---- OrganizationServiceImpl ---> save --- 标签不存在建立标签库同时搭建关系 ------");
                            Label lab = new Label();
                            long lableId = snowflakeIdWorker53.nextId();
                            lab.setId(lableId).setDelFlag(flag).setVal(la.replace(" ","")).setCreateTime(LocalDateTime.now());
                            labelMapper.insert(lab);
                            linklb.setDelFlag("0");
                            linklb.setId(snowflakeIdWorker53.nextId());
                            linklb.setType(4L);
                            linklb.setLabelId(lableId);
                            linklb.setSourceId(organizationId);
                            TLinkLabelMapper.insertLinkLabel(linklb);
                        }
                    }
                    log.info("---- OrganizationServiceImpl ---> save --- 录入下拉技术服务关联信息 -------");
                    log.info("--- OrganizationServiceImpl ---> save -- 循环技能方向数据 ---");

                }else {
                    return  new ResponseResult<Organization>("xxxx",null, "参数不匹配",LocalDateTime.now());
                }


        return  null;
    }*/

    /**
     * 修改实验室
     * @param updateOriganizationDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrganization(UpdateOriganizationDto updateOriganizationDto) {
        byte flag= 0;
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andIdEqualTo(updateOriganizationDto.getOperator()).andDelFlagEqualTo(flag);
        Member member = memberMapper.selectOneByExample(memberExample);
        if (member == null) {
            throw new BusinessException("用户不存在");
        }
        Long organizationId = member.getOrganizationId();
        if (!organizationId.equals(updateOriganizationDto.getId())) {
            throw new BusinessException("组织机构不存在");
        }
        OrganizationExample organizationExample = new OrganizationExample();

        Organization organization = Organization.builder().belong(updateOriganizationDto.getBelong()).
                updateTime(LocalDateTime.now()).summary(updateOriganizationDto.getSummary()).
                name(updateOriganizationDto.getName()).
                fundsId(updateOriganizationDto.getFundsId().toString()).
                scaleId(updateOriganizationDto.getScaleId()).build();
        organizationMapper.updateByExampleSelective(organization, organizationExample);
    }

    @Override
    public Page<OrganizationListRes> getOrganizationList(OrganizationListReq req) {
        return customOrganizationMapper.getOrganizationList(req);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrgan(OrganizationAddReq req) {
        long memberId = snowflakeIdWorker53.nextId();
        long organ = snowflakeIdWorker53.nextId();
        List<String> labelList = Arrays.asList(req.getLabels().replace("，",",").split(","));
        List<String> labels = labelList.stream().distinct().filter(StrUtil::isNotBlank).map(StrUtil::trim).collect(Collectors.toList());
        if (labels.size() > 5){
            throw new BusinessException(OrganizationErrorEnum.LABELS_TOO_LONG);
        }
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andPhoneEqualTo(req.getPhone()).andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue());
        Member member = memberMapper.selectOneByExample(memberExample);
        OrganizationExample organizationExample = new OrganizationExample();
        OrganizationExample.Criteria criteria = organizationExample.createCriteria();
        criteria.andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue()).andNameEqualTo(req.getName());
        if (req.getType() == 0){
            criteria.andBelongEqualTo(req.getBelong());
        }
        Organization organization = organizationMapper.selectOneByExample(organizationExample);
        if (organization != null && member != null){
            if (member.getOrganizationId() != null){
                throw new BusinessException(OrganizationErrorEnum.JOINED_ORGANIZATION);
            }
            if (member.getLevel() == -1){
                throw new BusinessException(OrganizationErrorEnum.MEMBER_FROZEN);
            }
            member.setOrganizationId(organization.getId());
            member.setUpdateBy(ShiroUtils.getUserId());
            member.setBelong(organization.getBelong());
            member.setVerifyStatus(0);
            member.setLicense(req.getLicense());
            member.setQualifications(req.getQualifications());
            return memberMapper.updateByPrimaryKeySelective(member);
        }
        if (organization != null && member == null){
            commonLabel(labels , memberId);
            return addMember(req , memberId , organization.getId());
        }
        if (organization == null && member != null){
            if (member.getOrganizationId() != null){
                throw new BusinessException(OrganizationErrorEnum.JOINED_ORGANIZATION);
            }
            member.setOrganizationId(organ);
            member.setUpdateBy(ShiroUtils.getUserId());
            member.setBelong(req.getBelong());
            member.setVerifyStatus(0);
            member.setLicense(req.getLicense());
            member.setQualifications(req.getQualifications());
            memberMapper.updateByPrimaryKeySelective(member);
            return addOrgan(req , organ , member.getId());
        }
        int addOrgan = addOrgan(req, organ, memberId);
        int addMember = addMember(req, memberId, organ);
        commonLabel(labels , memberId);
        return addOrgan+addMember;
    }

    @Override
    public Organization toUpdate(Long id) {
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andIdEqualTo(id).andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue());
        return organizationMapper.selectOneByExample(example);
    }

    @Override
    public int update(OrganizationUpdateReq req) {
        if (req.getType() == 0 && (!req.getOldBelong().equals(req.getBelong()) || !req.getOldName().equals(req.getName()))){
            OrganizationExample example = new OrganizationExample();
            example.createCriteria()
                    .andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue())
                    .andNameEqualTo(req.getName())
                    .andBelongEqualTo(req.getBelong());
            Organization organization1 = organizationMapper.selectOneByExample(example);
            if (organization1!= null){
                throw new BusinessException(OrganizationErrorEnum.ALREADY_EXISTS);
            }
        }
        if ( req.getType()==1 && !req.getOldName().equals(req.getName())){
            OrganizationExample example = new OrganizationExample();
            example.createCriteria()
                    .andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue())
                    .andNameEqualTo(req.getName());
            Organization organization1 = organizationMapper.selectOneByExample(example);
            if (organization1!= null){
                throw new BusinessException(OrganizationErrorEnum.ALREADY_EXISTS);
            }
        }
        Organization organization = new Organization();
        BeanUtils.copyProperties(req , organization);
        organization.setAddressDetail(req.getAddressProvinceName()+req.getAddressCityName()+req.getAddressAreaName());
        organization.setUpdateBy(ShiroUtils.getUserId());
        return organizationMapper.updateByPrimaryKeySelective(organization);
    }

    @Override
    public List<Member> getOrganMember(Long organId) {
        MemberExample example = new MemberExample();
        example.createCriteria().andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue()).andOrganizationIdEqualTo(organId);
        return memberMapper.selectByExample(example);
    }

    @Override
    public List<Organization> findByName(String name) {
        OrganizationExample example = new OrganizationExample();
        if (StringUtils.isNotEmpty(name)){
            example.createCriteria().andNameLike("%"+name+"%").andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue());
        }
        return organizationMapper.selectByExample(example);
    }

    private void commonLabel(List<String> labels , Long memberId){
        for (String match : labels) {
            if (VerifyMatch.containsAll(match)){
                throw new BusinessException(OrganizationErrorEnum.ILLEGAL_CHARACTER);
            }
            LabelExample labelExample = new LabelExample();
            labelExample.createCriteria().andValEqualTo(match).andDelFlagEqualTo(OrganizationEnum.DEL_FALSE.getValue());
            Label label = labelMapper.selectOneByExample(labelExample);
            if (label != null){
                LinkLabel linkLabel = new LinkLabel();
                linkLabel.setId(snowflakeIdWorker53.nextId());
                linkLabel.setLabelId(label.getId());
                linkLabel.setSourceId(memberId);
                linkLabel.setCreateBy(ShiroUtils.getUserId());
                linkLabel.setType(3);
                linkLabelMapper.insertSelective(linkLabel);
            }else {
                Label addLabel = new Label();
                addLabel.setId(snowflakeIdWorker53.nextId()).setVal(match).setCreateBy(ShiroUtils.getUserId());
                labelMapper.insertSelective(addLabel);
                linkLabelMapper.insertSelective(LinkLabel.builder().id(snowflakeIdWorker53.nextId()).createBy(ShiroUtils.getUserId()).labelId(addLabel.getId()).sourceId(memberId).type(3).build());
            }
        }
        /*JSONArray array = JSON.parseArray(serverIds);
        if (CollUtil.isNotEmpty(array)){
            for (Object serverId : array) {
                linkSelectMapper.insertSelective(LinkSelect.builder()
                        .id(snowflakeIdWorker53.nextId())
                        .type(0).selectConfigId(Long.valueOf(serverId.toString()))
                        .createBy(ShiroUtils.getUserId())
                        .sourceId(memberId).build());
            }
        }*/
    }

    private int addMember(OrganizationAddReq req , Long memberId , Long organId){
        return memberMapper.insertSelective(Member.builder()
                .id(memberId)
                .belong(req.getType() == 0 ? req.getBelong() : req.getName())
                .password(Md5Utils.encryptPassword("123456"))
                .organizationId(organId)
                .createBy(ShiroUtils.getUserId())
                .email(req.getEmail())
                .phone(req.getPhone())
                .license(req.getLicense())
                .qualifications(req.getQualifications())
                .verifyStatus(0)
                .educationId(req.getEducation() == null ? null : req.getEducation())
                .industryId(req.getIndustry())
                .positionId(req.getPosition())
                .name(req.getMemberName())
                .build());
    }
    private int addOrgan(OrganizationAddReq req , Long organ , Long memberId){
        return organizationMapper.insertSelective(Organization.builder()
                .id(organ)
                .name(req.getName())
                .createBy(ShiroUtils.getUserId())
                .type(req.getType())
                .belong(req.getBelong())
                .summary(req.getSummary())
                .industryId(req.getIndustry() == null ? 0L : req.getIndustry())
                .verifyStatus(2L)
                .industryRemark(req.getIndustryRemark())
                .license(req.getLicense())
                .responsibleMemberId(memberId)
                .addressProvinceId(Long.valueOf(req.getProvinceCode()))
                .addressProvinceName(req.getProvince())
                .addressCityId(Long.valueOf(req.getCityCode()))
                .addressCityName(req.getCity())
                .addressAreaId(Long.valueOf(req.getAreaCode()))
                .addressAreaName(req.getArea())
                .addressDetail(req.getProvince()+req.getCity()+req.getArea())
                .signTime(LocalDateTime.now())
                .scaleId(req.getScale())
                .techScaleId(req.getTechScale())
                .build());
    }



}
