package com.example.restApi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	
	//http://localhost:8092/api/v1/post-api/domain
	@PostMapping("/domain")
	//@RequestMapping(value = "/domain",method=RequestMethod.POST)
	public String postExample() {
		return "Hello Post Api";
	}
	
	@PostMapping("/member0")
	public String postMember0(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("addr") String addr) {
		
		return name + ", " + email +", "+ addr;
	}
	
	//http://localhost:8092/api/v1/post-api/member
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() +" : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	//http://localhost:8092/api/v1/post-api/member2
	@PostMapping("member2")
	public String postMemberDto2(@RequestBody MemberDto memberDto) {
		return memberDto.toString();	// 헤더부분 Content-Type:	text/plain;charset=UTF-8
	}
	
	//http://localhost:8092/api/v1/post-api/member3
		@PostMapping("member3")
		public MemberDto postMemberDto3(@RequestBody MemberDto memberDto) {
			return memberDto;	//위랑 다른건 응답의 형식이 다름 Content-Type:	application/json
		}
		
	
	
	
	
	
	
	
	
	
	
	
}
