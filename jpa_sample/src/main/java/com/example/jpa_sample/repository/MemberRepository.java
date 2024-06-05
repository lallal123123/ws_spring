package com.example.jpa_sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_sample.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	

}
