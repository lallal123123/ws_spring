package com.green.thymeBbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private int id;
	private String pw;
	private String name;
	private String role;
}
