package com.example.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.article.dto.Member;
import com.example.article.service.MemberService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	MemberService ms;
	@GetMapping("/member")
	public String getMember(@RequestParam("username") String username) {
		Member m =ms.findByUsername(username);
		String msg = "";
		if(m == null) {
			msg="사용가능한 아이디 입니다.";
		}else {
			msg="중복된 아이디입니다.";
		}
		return msg;
	}
}
