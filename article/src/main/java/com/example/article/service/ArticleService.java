package com.example.article.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.article.config.CustomUserDetails;
import com.example.article.dao.IArticleDao;
import com.example.article.dto.Article;
import com.example.article.dto.ArticleFile;

@Service
public class ArticleService {

	@Autowired
	IArticleDao adao;
	
	public void insert(ArticleFile articleFile,@AuthenticationPrincipal CustomUserDetails cud) throws  IOException {
		System.out.println("서비스 접속");
		Article article = new Article();
		article.setContent(articleFile.getContent());
		article.setTitle(articleFile.getTitle());
		article.setUsername(cud.getUsername());
		if(articleFile.getImg().isEmpty()) {
			article.setImg("x.jpg");
	
		}else {
			String fileName = articleFile.getImg().getOriginalFilename();

			String filePath = "src/main/resources/static/imgs/" + fileName;
			articleFile.getImg().transferTo(new FileSystemResource(filePath).getFile());
			article.setImg(fileName);
		}
		
		adao.insert(article);
	}
	
	public List<Article> findAllByApprove(int approve){
		return adao.findAllByApprove(approve);
	}
}
