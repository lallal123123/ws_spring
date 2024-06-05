package com.example.viewServer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.viewServer.config.CustomUserDetails;

@Controller
@RequestMapping("/journalist")
public class JournalistController {
	
	
	
	@RequestMapping("/articleWriteForm")
	public void articleWriteForm(@AuthenticationPrincipal CustomUserDetails cud,Model model) {
		model.addAttribute("username",cud.getUsername());
		
	}
	
	
}
