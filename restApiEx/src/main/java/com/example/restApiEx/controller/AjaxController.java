package com.example.restApiEx.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiEx.dto.Dash;
import com.example.restApiEx.dto.LoginDto;

@RestController
@RequestMapping("/api")
public class AjaxController {
	private Dash dash;
	private int c1= 0;
	private int c2= 0;
	public AjaxController(Dash dash) {
		this.dash = dash;
	}
	
	
	@PostMapping("/submitForm")
	public String submit(@RequestParam("username") String username,@RequestParam("password") String password) {
	
		c1++;
		dash.setC1(c1);
		
		return "submitted successfully username : "+ username + ", password : " + password + ", c1 : " +c1	;
	}
	
	@PostMapping("/submitJson")
	public String submitJson(@RequestBody LoginDto loginDto) {
		
		String username = loginDto.getUsername();
		String password = loginDto.getPassword();
		c2++;
		dash.setC2(c2);
		return "JSON submitted successfully  username : "+ username + ", password : " + password + ", c2 : " +c2	;
	}
	
}
