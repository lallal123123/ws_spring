package com.example.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restServer.Repository.MemberRepository;
import com.example.restServer.entity.Member;

@Service
public class MemberService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MemberRepository membersRepository;
	
	public boolean registMember(Member member) {
	
		
		String newPw = bCryptPasswordEncoder.encode(member.getPassword());
		member.setPassword(newPw);
		member.setRole("ROLE_USER");
		
		Member result = membersRepository.save(member);
		
		if(result != null) return true;
		
		return false;
	}

	public boolean joinProcess(Member joinDto) {
		Member member = new Member();
		member.setUsername(joinDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(joinDto.getPassword());
		member.setPassword(newPw);
		member.setRole("ROLE_USER");
		
		Member result = membersRepository.save(member);
		
		if(result != null) return true;
		
		return false;
	}
}
