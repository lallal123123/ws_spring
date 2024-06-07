package com.example.restServer.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	
	private Integer bno;
	private String title;
	private String content;
	
	private String writer;
	private MultipartFile file;
	
	public String getFileName() {
		return file.getOriginalFilename();
	}

}
