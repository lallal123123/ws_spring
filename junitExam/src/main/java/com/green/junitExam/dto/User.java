package com.green.junitExam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;
	private String pw;
	private int uno;

	public User(String id,String pw){
		this.id = id;
		this.pw = pw;
	}



}

