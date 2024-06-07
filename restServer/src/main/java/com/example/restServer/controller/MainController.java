package com.example.restServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restServer.Repository.MemberRepository;
import com.example.restServer.entity.Member;

@CrossOrigin(origins="*")
@RestController
public class MainController {

	@Autowired
	private MemberRepository mr;
	
	
	
	
	@PostMapping("/joinProc")
	public  String joinProc(Member member) {
		member.setRole("ROLE_MEMBER");
		//DB에 저장
		Member result = mr.save(member);
		if(result != null) {
			return "성공";
		}else {
			return "실패";
		}
		
	}
	
	
	
	
	
	
}
