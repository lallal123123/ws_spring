package com.example.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.article.dto.Member;
import com.example.article.service.MemberService;

@Controller
public class MyController {

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
