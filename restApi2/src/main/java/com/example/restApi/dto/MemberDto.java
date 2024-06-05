package com.example.restApi.dto;

import lombok.Data;

@Data
public class MemberDto { //DTO(Data Transfer Object) : 계층(레이어드 아키텍쳐)간 데이터 교환(전송)에 사용되는 객체
													// 프리젠테이션 - 비지니스 - 데이터엑세스
	private Integer mno;
	private String name;
	private String email;
	private String addr;
}
