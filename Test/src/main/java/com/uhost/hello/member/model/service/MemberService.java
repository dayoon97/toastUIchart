package com.uhost.hello.member.model.service;

import java.util.HashMap;
import java.util.List;

import com.uhost.hello.member.model.vo.Member;

public interface MemberService {

	List<Member> selectMember();

	int insertMember(HashMap<String, Object> map);

	int deleteMember(HashMap<String, Object> map);

	int updateMember(HashMap<String, Object> map);

	
}
