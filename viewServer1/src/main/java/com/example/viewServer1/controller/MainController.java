package com.example.viewServer1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String root() {
		System.out.println("root...............");
		return "index";
	}
	
	@GetMapping("/join")
	public String join() {
		return "joinForm";
	}
}
