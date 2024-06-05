package com.example.article.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ArticleFile {

	private int ano;
	private String title;
	private String writeDate;
	private String update;
	private String uploadDate;
	private String username;
	private String content;
	private MultipartFile img;
	private int approve;
}
