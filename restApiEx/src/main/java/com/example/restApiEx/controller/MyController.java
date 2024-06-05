package com.example.restApiEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restApiEx.dto.Dash;

@Controller
public class MyController {
	int num = 0;//빈들은 기본적으로 객체가 1개임(싱글턴 객체)그래서 int앞에 static을 안붙여도 됨
	
	@Autowired
	private Dash dash;
	
	@RequestMapping("/")
	public String root(Model model) {
		
		
		String msg = null;
		if(num==0) {
			 msg ="안녕";
			 num ++;
		}else if(num ==1) {
			msg ="니하오";
			num ++;
		}else if(num ==2) {
			msg ="hi";
			num ++;
		}else if(num ==3) {
			msg ="곤니찌와";
			num = 0;
		}
		model.addAttribute("msg",msg);
		
		return "index3";
	}
	
	@RequestMapping("/1")
	public String sd() {
		return "ajaxEx";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model) {
	
		model.addAttribute("dash", dash);
		return "admin";
	}@RequestMapping("/job")
	public void job() {
		
	}
}
