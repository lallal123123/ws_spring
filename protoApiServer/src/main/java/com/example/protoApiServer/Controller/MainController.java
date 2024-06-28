package com.example.protoApiServer.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.protoApiServer.dao.IMemberDao;
import com.example.protoApiServer.dto.Member;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	IMemberDao mdao;
	
	@GetMapping("/")
	public String root() {
		return "aaa";
	}
	@GetMapping("/member/{username}")
	public Member getMember(@PathVariable("username") String username) {
		
		
		return mdao.getMember(username);
	}
	@PostMapping("/member")
	public String regMember(@RequestBody Member member) {
		mdao.insert(member);
		
		return "성공";
	}
}
