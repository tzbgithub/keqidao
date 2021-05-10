package com.qidao.qidao.canal.canal.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.enums.ConstantEnum;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.canal.canal.domain.*;
import com.qidao.qidao.canal.canal.mapper.CanalMapper;
import com.qidao.qidao.canal.canal.service.CustomCanalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customCanalService")
public class CustomCanalServiceImpl implements CustomCanalService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private CanalMapper canalMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker53;

    @Override
    public List<CanalListRes> findCanalList(CanalListReq req) {
        CanalExample example = new CanalExample();
        CanalExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        if (StringUtils.isNotEmpty(req.getVersion())){
            criteria.andVersionLike("%"+req.getVersion()+"%");
        }
        example.setOrderByClause("create_time desc");
        List<Canal> canals = canalMapper.selectByExample(example);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        Page<CanalListRes> res = new Page<>();
        canals.forEach(canal -> {
            CanalListRes canalListRes = new CanalListRes();
            BeanUtils.copyProperties(canal , canalListRes);
            canalListRes.setDelFlag(Integer.valueOf(canal.getDelFlag()));
            canalListRes.setCreateBy(userMap.get(canal.getCreateBy()));
            res.add(canalListRes);
        });
        if (canals instanceof Page){
            res.setTotal(((Page<Canal>) canals).getTotal());
        }
        return res;
    }

    @Override
    public int save(CanalAddReq req) {
        Canal canal = new Canal();
        BeanUtils.copyProperties(req, canal);
        canal.setDelFlag(Byte.parseByte(req.getDelFlag().toString()));
        canal.setId(snowflakeIdWorker53.nextId());
        canal.setName(req.getName().replace(" ", ""));
        canal.setVersion(req.getVersion().replace(" ",""));
        canal.setCreateBy(ShiroUtils.getUserId());
        return canalMapper.insertSelective(canal);
    }

    @Override
    public int enable(Long id) {
        return canalMapper.updateByPrimaryKeySelective(Canal.builder().id(id).updateBy(ShiroUtils.getUserId()).delFlag(ConstantEnum.NOT_DEL.getValue()).build());
    }

    @Override
    public int close(Long id) {
        return canalMapper.updateByPrimaryKeySelective(Canal.builder().id(id).updateBy(ShiroUtils.getUserId()).delFlag(ConstantEnum.DELETED.getValue()).build());
    }

    @Override
    public List<Canal> findAllCanal() {
        CanalExample example = new CanalExample();
        example.createCriteria().andDelFlagEqualTo((byte)0);
        return canalMapper.selectByExample(example);
    }
}
