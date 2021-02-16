package com.uhost.hello.member.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.uhost.hello.member.model.vo.Member;

public interface MemberDao {

	List<Member> selectMember(SqlSessionTemplate sqlSession);

	int deleteMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map);

	int insertMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map);
	
	int updateMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map);

}
