package com.example.sec_jpa_thyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sec_jpa_thyme.dto.MemberDto;
import com.example.sec_jpa_thyme.entity.Member;
import com.example.sec_jpa_thyme.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MyController {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping("/")
	public String root() {
		log.info("root................");
		return "index";
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		log.info("registForm.....");
		return "registForm";
	}
	
	@RequestMapping("/registProc")
	public @ResponseBody String registProc(MemberDto memberDto) {
		log.info("registProc......" + memberDto);
		
		Member member = new Member();
		member.setUsername(memberDto.getUsername());
		
		String newPw = bCryptPasswordEncoder.encode(memberDto.getPassword());
		member.setPassword(newPw);
		member.setName(memberDto.getName());
		member.setRole("ROLE_MEMBER");
		
		memberRepository.save(member);
		
		
		return "회원가입 완료됨.";
	}
	@RequestMapping("/login")
	public String login() {
		return "login2";
	}
	@RequestMapping("success")
	public void success() {
		
	}
}
