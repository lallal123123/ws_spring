package com.example.sec_jpa_thyme.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sec_jpa_thyme.config.CustomUserDetails;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@RequestMapping("/")
	public String welcome(Model model, Principal principal, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
		System.out.println("member welcome.....");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
		
		model.addAttribute("name", userDetails.getName());
		model.addAttribute("username",userDetails.getUsername());
		model.addAttribute("role",userDetails.getRole());
		//Principal 객체 주입 : 사용자 인증 정보를 가진 객체, 단점: 다른 정보(이름,전화번호) 불러오기 힘듬 
		model.addAttribute("username2", principal.getName());	//getName()은 username을 뜻함 그냥 name 아님!
		
		//@AuthenticationPrincipal을 사용하여 UserDetails 인터페이스의 구현체 CustomUserDetails 객체를 주입받아 사용하기
		model.addAttribute("username3", customUserDetails.getUsername());
		model.addAttribute("name3", customUserDetails.getName());
		model.addAttribute("role3", customUserDetails.getRole());
		model.addAttribute("details", customUserDetails);
		
		
		return "members/welcome";
		
	}

}
