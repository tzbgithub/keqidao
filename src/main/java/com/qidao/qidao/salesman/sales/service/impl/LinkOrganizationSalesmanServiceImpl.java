package com.qidao.qidao.salesman.sales.service.impl;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.qidao.dynamic.domain.Dynamic;
import com.qidao.qidao.dynamic.domain.DynamicExample;
import com.qidao.qidao.dynamic.mapper.DynamicMapper;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipment;
import com.qidao.qidao.equipment.equipment.domain.AchievementEquipmentExample;
import com.qidao.qidao.equipment.equipment.mapper.AchievementEquipmentMapper;
import com.qidao.qidao.link.publishContent.domain.LinkPublishContent;
import com.qidao.qidao.link.publishContent.domain.LinkPublishContentExample;
import com.qidao.qidao.link.publishContent.domain.enums.PublishContentEnum;
import com.qidao.qidao.link.publishContent.mapper.LinkPublishContentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.salesman.sales.mapper.LinkOrganizationSalesmanMapper;
import com.qidao.qidao.salesman.sales.domain.LinkOrganizationSalesman;
import com.qidao.qidao.salesman.sales.service.ILinkOrganizationSalesmanService;
import com.qidao.common.utils.text.Convert;
import com.qidao.framework.util.SnowflakeIdWorker53;

import javax.annotation.Resource;


/**
 * 销售关联组织机构Service业务层处理
 *
 * @author autuan
 * @date 2021-02-01
 */
@Service
@Slf4j
public class LinkOrganizationSalesmanServiceImpl implements ILinkOrganizationSalesmanService {
    @Resource
    private LinkOrganizationSalesmanMapper linkOrganizationSalesmanMapper;
    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;
    @Resource
    private LinkPublishContentMapper linkPublishContentMapper;

    @Resource
    private DynamicMapper dynamicMapper;

    @Resource
    private AchievementEquipmentMapper achievementEquipmentMapper;

    /**
     * 查询销售关联组织机构
     *
     * @param id 销售关联组织机构ID
     * @return 销售关联组织机构
     */
    @Override
    public LinkOrganizationSalesman selectLinkOrganizationSalesmanById(Long id) {
        log.info("LinkOrganizationSalesmanServiceImpl -> selectLinkOrganizationSalesmanById -> start -> id : {}", id);
        log.info("LinkOrganizationSalesmanServiceImpl -> selectLinkOrganizationSalesmanById -> end");
        return linkOrganizationSalesmanMapper.selectLinkOrganizationSalesmanById(id);
    }

    /**
     * 查询销售关联组织机构列表
     *
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 销售关联组织机构
     */
    @Override
    public List<LinkOrganizationSalesman> selectLinkOrganizationSalesmanList(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanServiceImpl -> selectLinkOrganizationSalesmanList -> start -> linkOrganizationSalesman : {}", linkOrganizationSalesman);
        List<LinkOrganizationSalesman> salesmen = linkOrganizationSalesmanMapper.selectLinkOrganizationSalesmanList(linkOrganizationSalesman);
        salesmen.forEach(s -> {
            LinkPublishContentExample logDynamicExample = new LinkPublishContentExample();
            logDynamicExample.createCriteria()
                    .andTypeEqualTo(PublishContentEnum.TYPE_DYNAMIC.getCode())
                    .andPublishTypeEqualTo(PublishContentEnum.PUBLISH_TYPE_SALESMAN.getCode())
                    .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue())
                    .andMemberIdEqualTo(s.getMemberId());
            List<LinkPublishContent> logDynamic = linkPublishContentMapper.selectByExample(logDynamicExample);
            DynamicExample dynamicExample = new DynamicExample();
            dynamicExample.createCriteria()
                    .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue())
                    .andMemberIdEqualTo(s.getMemberId());
            List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
            s.setDynamicNum(logDynamic.size()+dynamics.size()+"("+logDynamic.size()+")");

            LinkPublishContentExample logEquipmentExample = new LinkPublishContentExample();
            logDynamicExample.createCriteria()
                    .andTypeEqualTo(PublishContentEnum.TYPE_EQUIPMENT.getCode())
                    .andPublishTypeEqualTo(PublishContentEnum.PUBLISH_TYPE_SALESMAN.getCode())
                    .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue())
                    .andMemberIdEqualTo(s.getMemberId());
            linkPublishContentMapper.selectByExample(logEquipmentExample);
            AchievementEquipmentExample equipmentExample = new AchievementEquipmentExample();
            equipmentExample.createCriteria()
                    .andDelFlagEqualTo(ConstantEnum.NOT_DEL.getValue())
                    .andMemberIdEqualTo(s.getMemberId());
            List<AchievementEquipment> equipments = achievementEquipmentMapper.selectByExample(equipmentExample);
            s.setEquipmentNum(logDynamic.size()+equipments.size()+"("+logDynamic.size()+")");

        });
        log.info("LinkOrganizationSalesmanServiceImpl -> selectLinkOrganizationSalesmanList -> end");
        return salesmen;
    }

    /**
     * 新增销售关联组织机构
     *
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 结果
     */
    @Override
    public int insertLinkOrganizationSalesman(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanServiceImpl -> insertLinkOrganizationSalesman -> start -> linkOrganizationSalesman : {}", linkOrganizationSalesman);
        linkOrganizationSalesman.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        linkOrganizationSalesman.setId(snowflakeIdWorker.nextId());
        log.info("LinkOrganizationSalesmanServiceImpl -> insertLinkOrganizationSalesman -> end");
        return linkOrganizationSalesmanMapper.insertLinkOrganizationSalesman(linkOrganizationSalesman);
    }

    /**
     * 修改销售关联组织机构
     *
     * @param linkOrganizationSalesman 销售关联组织机构
     * @return 结果
     */
    @Override
    public int updateLinkOrganizationSalesman(LinkOrganizationSalesman linkOrganizationSalesman) {
        log.info("LinkOrganizationSalesmanServiceImpl -> updateLinkOrganizationSalesman -> start -> linkOrganizationSalesman : {}", linkOrganizationSalesman);
        linkOrganizationSalesman.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
        log.info("LinkOrganizationSalesmanServiceImpl -> updateLinkOrganizationSalesman -> end");
        return linkOrganizationSalesmanMapper.updateLinkOrganizationSalesman(linkOrganizationSalesman);
    }

    /**
     * 删除销售关联组织机构对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLinkOrganizationSalesmanByIds(String ids) {
        log.info("LinkOrganizationSalesmanServiceImpl -> deleteLinkOrganizationSalesmanByIds -> start -> ids : {}", ids);
        log.info("LinkOrganizationSalesmanServiceImpl -> deleteLinkOrganizationSalesmanByIds -> end");
        return linkOrganizationSalesmanMapper.deleteLinkOrganizationSalesmanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售关联组织机构信息
     *
     * @param id 销售关联组织机构ID
     * @return 结果
     */
    @Override
    public int deleteLinkOrganizationSalesmanById(Long id) {
        log.info("LinkOrganizationSalesmanServiceImpl -> deleteLinkOrganizationSalesmanById -> start -> id : {}", id);
        log.info("LinkOrganizationSalesmanServiceImpl -> deleteLinkOrganizationSalesmanById -> end");
        return linkOrganizationSalesmanMapper.deleteLinkOrganizationSalesmanById(id);
    }


    /**
     * 逻辑删除销售关联组织机构对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int logicDelByIds(String ids) {
        log.info("LinkOrganizationSalesmanServiceImpl -> logicDelByIds -> start -> ids : {}", ids);
        log.info("LinkOrganizationSalesmanServiceImpl -> logicDelByIds -> end");
        return linkOrganizationSalesmanMapper.logicDelByIds(Convert.toStrArray(ids));
    }

}
