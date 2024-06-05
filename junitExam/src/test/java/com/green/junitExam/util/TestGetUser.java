package com.green.junitExam.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.junitExam.dao.IUserDao;
import com.green.junitExam.dto.User;


@SpringBootTest
class TestGetUser {

	@Autowired
	IUserDao dao ;
	
	@Test
	void getUserTest() {
		int uno=1;
		User user =dao.getUser(uno);
		System.out.println(user);
		assertThat(user.getId()).isEqualTo("홍길동");
		assertThat(user.getPw()).isEqualTo("111");
		assertThat(user.getUno()).isEqualTo(1);
		
		uno=2;
		user =dao.getUser(uno);
		System.out.println(user);
		assertThat(user.getId()).isEqualTo("임꺽정");
		assertThat(user.getPw()).isEqualTo("222");
		assertThat(user.getUno()).isEqualTo(2);
	}

}
