package com.example.article.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.article.config.CustomUserDetails;
import com.example.article.dao.IArticleDao;
import com.example.article.dto.ArticleFile;
import com.example.article.service.ArticleService;

@Controller
@RequestMapping("/journalist")
public class JournalistController {
	
	@Autowired
	ArticleService as;
	
	@RequestMapping("/articleWriteForm")
	public void articleWriteForm() {
		
	}
	@RequestMapping("/articleWrite")
	public String articlWrite(ArticleFile articleFile,@AuthenticationPrincipal CustomUserDetails cud) throws IllegalStateException, IOException {
		System.out.println("컨트롤러 접속");
		as.insert(articleFile, cud);
		return "/index";
	}
	
}
