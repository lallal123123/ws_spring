package com.example.jpaBbs.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpaBbs.Repository.UserRepository;
import com.example.jpaBbs.entity.User;

@SpringBootTest
public class UserRepositoryTests {
	@Autowired
	UserRepository ur;
	
	//@Test
	public void getUserList() {
		List<User> list =ur.getUserList("홍길동");
		
		assertThat(list.get(0).getUsername()).isEqualTo("aaa");
	}
	
	//@Test
	public void getUserList2() {
		List<User> list =ur.getUserList2("홍길동");
		
		assertThat(list.get(0).getUsername()).isEqualTo("aaa");
	}
	
	@Test
	public void getTelUser() {
		List<Object[]> list = ur.getTelUser();
		
		System.out.println("tel : " + list.get(0)[0]);
		System.out.println("count : " + list.get(0)[1]);
		
		for(Object[] objs : list) {
			System.out.println(Arrays.toString(objs));
		}
		
	}
	//@Test
	public void getTotal() {
		int result = ur.getTotal();
		System.out.println(result);
	}
	
	
}
