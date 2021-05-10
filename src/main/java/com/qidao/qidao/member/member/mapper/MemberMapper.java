package com.qidao.qidao.member.member.mapper;

import com.qidao.qidao.member.member.domain.Member;
import com.qidao.qidao.member.member.domain.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(@Param("record") Member record, @Param("selective") Member.Column ... selective);

    Member selectOneByExample(MemberExample example);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example, @Param("selective") Member.Column ... selective);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(@Param("record") Member record, @Param("selective") Member.Column ... selective);

    int updateByPrimaryKey(Member record);

    int batchInsert(@Param("list") List<Member> list);

    int batchInsertSelective(@Param("list") List<Member> list, @Param("selective") Member.Column ... selective);
}