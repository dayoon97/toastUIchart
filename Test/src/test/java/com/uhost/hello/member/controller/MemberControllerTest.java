package com.uhost.hello.member.controller;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.servlet.ModelAndView;


public class MemberControllerTest {

	@Inject
	private MemberController controller;
	//privatee MockMvc mockMvc;
	
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//	}
	
	@Test
	public void testDeleteMember() throws Exception{
		MemberController mc = new MemberController();
		ModelAndView test = mc.deleteMember(null, "홍길동", "01078945612");
		
	}
	

}
