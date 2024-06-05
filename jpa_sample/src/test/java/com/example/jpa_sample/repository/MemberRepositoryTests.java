package com.example.jpa_sample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_sample.entity.Member;

@SpringBootTest
public class MemberRepositoryTests {

	@Autowired
	MemberRepository mr;
	
	@Test
	public void insert() {
		for(int i =1; i<101 ;i++ ){
			Member member= new Member("user"+i+"@naver.com","111","user"+i);
					mr.save(member);
		}
	}
}
