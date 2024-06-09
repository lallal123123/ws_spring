package com.example.restServer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restServer.Repository.MemberRepository;
import com.example.restServer.entity.Member;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberRepository membersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		Member member = membersRepository.findByUsername(username);
		
		System.out.println("userEntity : " + member);
		
		if(member != null) {
			CustomUserDetails userData = new CustomUserDetails(member);
			return userData;
		}
		
		return null;
	}

}