package com.example.viewServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.viewServer.dto.Member;
import com.example.viewServer.service.MemberService;

@Controller
public class MainController {

	@Autowired
	MemberService ms;	
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	@RequestMapping("/regForm")
	public void regForm() {
		
	}
	@RequestMapping("/reg")
	public String reg(Member member) {
		ms.reg(member);
		return"index";
	}
	
}
