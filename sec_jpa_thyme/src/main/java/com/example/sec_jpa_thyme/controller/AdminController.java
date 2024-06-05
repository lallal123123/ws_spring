package com.example.sec_jpa_thyme.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sec_jpa_thyme.config.CustomUserDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping("/")
	public String welcome(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		System.out.println("admin welcome......");
		model.addAttribute("username",customUserDetails.getUsername());
		model.addAttribute("name",customUserDetails.getName());
		model.addAttribute("role",customUserDetails.getRole());
		return "admin/welcome";
	}
	
}
