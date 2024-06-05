package com.example.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.article.config.SecurityConfig;
import com.example.article.dao.IMemberDao;
import com.example.article.dto.Member;

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
