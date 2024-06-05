package com.green.junitExam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.junitExam.dto.User;
@Mapper
public interface IUserDao {

	public User getUser(@Param("uno") int uno);
	public List<User> getUserList();
	public int saveUser(@Param("user") User user);
	public int deleteUser(@Param("uno") int uno);
	
}
