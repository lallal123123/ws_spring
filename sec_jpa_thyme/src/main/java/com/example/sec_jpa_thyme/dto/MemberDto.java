package com.example.sec_jpa_thyme.dto;

import lombok.Data;

@Data
public class MemberDto {
	private Integer mno;
	private String username;
	private String password;
	private String name;
	private String role;
}
