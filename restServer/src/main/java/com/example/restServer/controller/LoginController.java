package com.example.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restServer.Repository.MemberRepository;
import com.example.restServer.entity.Member;

@CrossOrigin("*")
@RestController
public class LoginController {

	@Autowired
	MemberRepository mr;
	
	
	
	@PostMapping("/loginProc")
	public  String loginProc(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		//DB에서 아이디, 패스워드 있는지 확인
		Member result =mr.findByUsernameAndPassword(username, password);
		if(result != null){
			return "로그인성공";
			
		}else {
			return "로그인실패";
		}
	}
}
