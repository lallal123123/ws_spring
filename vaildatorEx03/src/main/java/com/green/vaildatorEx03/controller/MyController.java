package com.green.vaildatorEx03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.vaildatorEx03.dto.ContentDto;

@Controller 	// 스프링에서 관리하는 Bean으로 등록시키는 명령.(@Component)
public class MyController {
	
	@RequestMapping("/")
	public String root() {
		
		return "index";
	}
	@RequestMapping("/insertForm")
	public void insertForm() {
		System.out.println("insertForm.....");
		
	}
	@RequestMapping("/create")
	public String insert(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
		String view = "createDonePage";
		System.out.println(contentDto);
		
		
		if(result.hasErrors()) {
			
			//System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null){
				System.out.println("1 : " +result.getFieldError("writer").getDefaultMessage());
			}
			
			if(result.getFieldError("content") != null){
				System.out.println("2 : " +result.getFieldError("content").getDefaultMessage());
			}
			view = "insertForm";
		}
		
		return view;
	}

	//InitBinder 삭제
	
	
}
