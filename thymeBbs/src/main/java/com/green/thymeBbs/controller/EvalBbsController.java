package com.green.thymeBbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.thymeBbs.dao.IEvalBbsDao;
import com.green.thymeBbs.dto.EvalBbsDto;

@Controller
public class EvalBbsController {

	@Autowired
	IEvalBbsDao dao;
	
	
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		List<EvalBbsDto> list =dao.list(); 
		model.addAttribute("list",list );
		
	}
	@RequestMapping("/detail")
	public void detail(@RequestParam("bno") String bno, Model model) {
		EvalBbsDto dto =dao.detail(bno); 
		model.addAttribute("dto",dto );
		
	}
	
	@RequestMapping("/writeForm")
	public String detail() {
		
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String detail(EvalBbsDto dto) {
		dao.write(dto);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String detail(@RequestParam("bno") String bno) {
		dao.delete(bno); 
		return "redirect:list";
		
	}
	
	
}
