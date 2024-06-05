package com.example.viewServer.dto;

import lombok.Data;

@Data
public class Article {

	private int ano;
	private String title;
	private String writeDate;
	private String update;
	private String uploadDate;
	private String username;
	private String content;
	private String img;
	private int approve;
}
