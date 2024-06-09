package com.example.restServer.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restServer.Repository.MemberRepository;
import com.example.restServer.entity.Member;

@CrossOrigin(origins="*")
@RestController
public class MainController {

	@Autowired
	private MemberRepository mr;
	
	 @GetMapping("/")
	    public String mainP() {
	    	String name = SecurityContextHolder.getContext().getAuthentication().getName();

	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	    	Iterator<? extends GrantedAuthority> iter = authorities.iterator();
	    	GrantedAuthority auth = iter.next();
	    	String role = auth.getAuthority();
	    	
	        return "Main Controller username: "+name + ", role : " + role;
	    }
	
	
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
