package com.uhost.hello.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uhost.hello.member.model.service.MemberService;
import com.uhost.hello.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("selectMember.me")
	public ModelAndView selectMember(ModelAndView mv) {
		
		List<Member> list = new ArrayList<Member>();
		list = ms.selectMember();
		
        mv.addObject("list", list);
        mv.setViewName("jsonView");
		
        return mv;
    }
	
	@RequestMapping("deleteMember.me")
	public ModelAndView deleteMember(ModelAndView mv, String name, String phone) {
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone", phone);
		
		int cnt = 0;
		cnt = ms.deleteMember(map);
		
		mv.addObject("cnt", cnt);
		mv.setViewName("jsonView");
		
		System.out.println("mv: " + mv);
		
		return mv;
        
    }
	
	@RequestMapping("insertMember.me")
	public ModelAndView insertMember(ModelAndView mv, String name, String address, String phone, String gender) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("address", address);
		map.put("gender", gender);
		
		int cnt = 0;
		cnt = ms.insertMember(map);
		
		mv.addObject("cnt", cnt);
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping("updateMember.me")
	public ModelAndView updateMember(ModelAndView mv, String name, String address, String phone, String gender, int no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("address", address);
		map.put("gender", gender);
		map.put("no", no);
		
		int cnt = 0;
		cnt = ms.updateMember(map);
		
		mv.addObject("cnt", cnt);
		mv.setViewName("jsonView");
		
		return mv;
	}
}
