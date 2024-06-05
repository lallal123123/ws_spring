package com.example.restApi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	//http://localhost:8092/api/v1/put-api/member
	@PutMapping("/member")
	public String putMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@PutMapping("/member2")
	public String putMember2(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
	
	@PutMapping("/member3")
	public MemberDto putMember3(@RequestBody MemberDto memberDto) {
		return memberDto;
	}

	@PutMapping("/member4")
	public ResponseEntity<MemberDto> putMemberDto4(@RequestBody MemberDto memberDto){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)//HttpStatus.뒤에 오는 것에 따라 상태가 달라짐 404,405같이 숫자가 달라짐 accepted 면 202
				.body(memberDto);
	}
}
