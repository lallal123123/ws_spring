package com.example.jpaBbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
}
