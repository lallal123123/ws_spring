package com.example.viewServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.viewServer.config.SecurityConfig;
import com.example.viewServer.dao.IMemberDao;
import com.example.viewServer.dto.Member;

@Service
public class MemberService {

	@Autowired
	SecurityConfig sc;
	@Autowired
	IMemberDao mdao;
	
	public void reg(Member member) {
		BCryptPasswordEncoder bc =sc.bCryptPasswordEncoder();
		member.setPassword(bc.encode(member.getPassword()));
		mdao.reg(member);
	}
	
	public Member findByUsername(String username) {
		return mdao.findByUsername(username);
	}
}
