package com.example.jdbcPrj.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jdbcPrj.dao.MemberDao;
import com.example.jdbcPrj.domain.MemberDto;

@Controller
public class JdbcController {
	@Autowired	
	private MemberDao memberDao;
	
	
	@RequestMapping("/")
	public String root() {
		
		return "index";
	}
	
	@RequestMapping("/memberList")
	public String memberListPage(Model model) {
		model.addAttribute("members",memberDao.getList());
		return "memberList";
	}
	
	/*	인터페이스로 선언한걸 이용해보고 싶었으나 
	 * Action: Consider defining a bean of type 'java.util.List' in your configuration.
	 * 이란 문구가 나옴 
	 * 
	@Autowired
	private List<MemberDto> list;
	
	@RequestMapping("/11")
	public @ResponseBody List<MemberDto> roo1212() {
		list=memberDao.getList();
		return list;
	}
	*/
}
