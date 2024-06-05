package com.green.junitExam.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.junitExam.dao.IUserDao;
import com.green.junitExam.dto.User;
@SpringBootTest
class TestSaveUser {

	@Autowired
	IUserDao dao ;
	
	@Test
	void saveUserTest1() {
		User user =new User(null,"23");
		int result= dao.saveUser(user);
		assertThat(result).isEqualTo(0);
	}
	
	
	@Test
	void saveUserTest2() {
		User user =new User("이영희","233");
		int result= dao.saveUser(user);
		assertThat(result).isEqualTo(1);
	}

}
