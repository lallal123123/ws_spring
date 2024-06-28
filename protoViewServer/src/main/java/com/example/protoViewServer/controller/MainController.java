package com.example.protoViewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class MainController {
	@RequestMapping("/")
	public String root() {
		return "index";
		
	}
	
	@RequestMapping("/loginForm")
	public void loginForm() {
		
	}
	@RequestMapping("/regForm")
	public void regForm() {
		
	}
	@RequestMapping("/mypage")
	public void mypage(@RequestParam("username") String username,Model model) {
		model.addAttribute("username", username);
		
	
	}

}
