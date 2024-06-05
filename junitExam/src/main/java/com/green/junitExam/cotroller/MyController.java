package com.green.junitExam.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.junitExam.dao.IUserDao;
import com.green.junitExam.dto.User;

@Controller
public class MyController {

	@Autowired
	IUserDao dao;
	
	@RequestMapping("/")
	public @ResponseBody User root() {
		User user=dao.getUser(2);
		
		return user;
	}
	
}
