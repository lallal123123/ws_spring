package com.example.restApi2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
//	@GetMapping("/member/{mno}")
//	public String memberByMno(@PathVariable("mno") Integer mno) {
//		String result = null;
//		
//		
//		return result;
//	}
}
