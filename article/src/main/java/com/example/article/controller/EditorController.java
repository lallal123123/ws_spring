package com.example.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.article.service.ArticleService;

@Controller
@RequestMapping("/editor")
public class EditorController {
	
	@Autowired
	ArticleService as;
	
	@RequestMapping("nonApprove")
	public void nonApprove(Model model) {
		model.addAttribute("articleList", as.findAllByApprove(0));
		
	}
	
}
