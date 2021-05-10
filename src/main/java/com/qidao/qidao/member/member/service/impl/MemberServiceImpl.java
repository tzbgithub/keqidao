package com.qidao.qidao.member.member. service.impl;

import java.util.List;
                                                                                                                                                                                                                                                                                                                                                                                                import com.qidao.common.utils.security.ShiroUtils;

import com.qidao.qidao.member.member.domain.TMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidao.qidao.member.member.mapper.TMemberMapper;
import com.qidao.qidao.member.member. service.IMemberService;
import com.qidao.common.utils.text.Convert;
import com.qidao.qidao.tools.snowflake.SnowflakeId;

import javax.annotation.Resource;


/**
 * 用户Service业务层处理
 *
 * @author autuan
 * @date 2020-12-16
 */
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private TMemberMapper TMemberMapper;
    @Resource
    private SnowflakeId snowflakeId;
    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public TMember selectMemberById(String id) {
        return TMemberMapper.selectMemberById(id);
    }

    /**
     * 查询用户列表
     *
     * @param TMember 用户
     * @return 用户
     */
    @Override
    public List<TMember> selectMemberList(TMember TMember) {
        return TMemberMapper.selectMemberList(TMember);
    }

    /**
     * 新增用户
     *
     * @param TMember 用户
     * @return 结果
     */
    @Override
    public int insertMember(TMember TMember) {
                                                                                                                                                                                                                                                                                                                                                                                                                TMember.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
                                                                                        TMember.setId(String.valueOf(snowflakeId.nextId()));
        return TMemberMapper.insertMember(TMember);
    }

    /**
     * 修改用户
     *
     * @param TMember 用户
     * @return 结果
     */
    @Override
    public int updateMember(TMember TMember) {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                            TMember.setUpdateBy(String.valueOf(ShiroUtils.getUserId()));
            
                    
                    
                    
                    
                return TMemberMapper.updateMember(TMember);
    }

    /**
     * 删除用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMemberByIds(String ids) {
        return TMemberMapper.deleteMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteMemberById(String id) {
        return TMemberMapper.deleteMemberById(id);
    }
    


                                                                                                                                                                                                                                    /**
             * 逻辑删除用户对象
             *
             * @param ids 需要删除的数据ID
             * @return 结果
             */
            @Override
            public int logicDelByIds(String ids) {
                return TMemberMapper.logicDelByIds(Convert.toStrArray(ids));
            }
                                                                        
}
