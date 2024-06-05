package com.green.junitExam.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.junitExam.dao.IUserDao;
import com.green.junitExam.dto.User;

@SpringBootTest
class TestDeleteUser {

	@Autowired
	IUserDao dao;
	
	@Test
	void deleteUserTest() {
		List<User> list = dao.getUserList();
		assertThat(list.size()).isEqualTo(5);
		int uno =6;
		int result = dao.deleteUser(uno);
		assertThat(result).isEqualTo(1);
		list = dao.getUserList();
		assertThat(list.size()).isEqualTo(4);
	}

}
