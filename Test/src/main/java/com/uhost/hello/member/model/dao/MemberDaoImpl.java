package com.uhost.hello.member.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.uhost.hello.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> selectMember(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("Member.selectMember");
	}

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("Member.insertMember", map);
	}

	@Override
	public int deleteMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.delete("Member.deleteMember", map);
	}

	@Override
	public int updateMember(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("Member.updateMember", map);
	}

}
