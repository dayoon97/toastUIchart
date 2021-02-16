package com.uhost.hello.member.model.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uhost.hello.member.model.dao.MemberDao;
import com.uhost.hello.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao md;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Member> selectMember() {
		return md.selectMember(sqlSession);
	}


	@Override
	public int insertMember(HashMap<String, Object> map) {
		return md.insertMember(sqlSession, map);
	}

	@Override
	public int deleteMember(HashMap<String, Object> map) {
		return md.deleteMember(sqlSession, map);
	}


	@Override
	public int updateMember(HashMap<String, Object> map) {
		return md.updateMember(sqlSession, map);
	}
	

}
