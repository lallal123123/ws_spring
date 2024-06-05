package com.example.restApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.entity.MemberEntity;
import com.example.restApi.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8094")
public class MemberController {
	
	@Autowired
	MemberRepository mr;
	
	@GetMapping("/member")
	public List<MemberEntity> getList() {
		List<MemberEntity> mem = mr.findAll();
		
		return mem;
	}
	@GetMapping("/member/{mno}")
	public String getMember(@PathVariable("mno") Integer mno){
		return mr.findById(mno).toString();
	}
	@PostMapping("/member")
	public MemberEntity postMember(MemberEntity member) {
	//커멘드 객체는 모델에 심지않아도 뷰에서 볼수있다?
		mr.save(member);
		return member;
	}
	@DeleteMapping("/member")
	public String deleteMember(@RequestParam("mno") Integer mno) {
		mr.deleteById(mno);
		return "mno : " + mno +"번 삭제";
	}
	

}
