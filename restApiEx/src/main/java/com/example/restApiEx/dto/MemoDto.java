package com.example.restApiEx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoDto {

	private Integer mno;
	private String title;
	private String content;
	private String writer;
}
