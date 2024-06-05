package com.example.jpaBbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

	
	private long bno;
	private String title;
	private String content;
	private String writer;
}
