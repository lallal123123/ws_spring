package com.example.sec_jpa_thyme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec_jpa_thyme.entity.Member;


public interface MemberRepository extends JpaRepository<Member,Integer> {

	Member findByUsername(String username);

	
}
