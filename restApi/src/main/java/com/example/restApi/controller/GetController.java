package com.example.restApi.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.entity.MemberEntity;
import com.example.restApi.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/get-api")
@CrossOrigin(origins = "http://localhost:8094")
public class GetController {
	
	@Autowired
	MemberRepository mr;
	
	//http://localhost:8092/api/v1/get-api/hello
	@GetMapping("/hello")
	public String getHello() {
		
		return "Hello RestApi~~";
	}
	//http://localhost:8092/api/v1/get-api/name
	@GetMapping("/name")
	public String getName() {
		
		return "HongGilDong";
	}
	//http://localhost:8092/api/v1/get-api/variable1/123
	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable("variable") String variable) {
		return variable;
	}
	
	@GetMapping("/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	//http://localhost:8092/api/v1/get-api/request?name=홍길동&email=aaa@naver.com&addr=부산
	@GetMapping("/request")
	public String getRequestParam1(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("addr") String addr
			) {
		return name + "," +email + "," + addr;
			
	}
	
	//선택사항을 받을때 유용함
	//http://localhost:8092/api/v1/get-api/request2?name=james&email=james@naver.com&addr=seoul&nickname=nicname111
	@GetMapping("/request2")
	public String getRequestParam2(@RequestParam Map<String, String > param) {
		
		StringBuilder sb =new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		
		return sb.toString();
	}
	//http://localhost:8092/api/v1/get-api/request3?name=james&email=james@naver.com&addr=seoul
	@GetMapping("/request3")
	public String getRequestParam3(MemberEntity member) {
	//커멘드 객체는 모델에 심지않아도 뷰에서 볼수있다?
		mr.save(member);
		return member.toString();
	}
	
	@GetMapping("/member")
	public Optional<MemberEntity> getMemberById(@RequestParam("mno") Integer mno) {
		Optional<MemberEntity> mem = mr.findById(mno);
		
		return mem;
	}
	@PostMapping("/member")
	public MemberEntity postMember(MemberEntity member) {
	//커멘드 객체는 모델에 심지않아도 뷰에서 볼수있다?
		mr.save(member);
		return member;
	}
	
	
	
}
