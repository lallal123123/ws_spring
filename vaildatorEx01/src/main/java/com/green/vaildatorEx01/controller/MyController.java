package com.green.vaildatorEx01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.vaildatorEx01.dto.ContentDto;
import com.green.vaildatorEx01.util.ContentValidator;

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
	public String insert(@ModelAttribute("dto") ContentDto contentDto, BindingResult result) {
		String view = "createDonePage";
		System.out.println(contentDto);
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		
		if(result.hasErrors()) {
			
			System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null){
				System.out.println("1 : " +result.getFieldError("writer").getCode());
			}
			
			if(result.getFieldError("content") != null){
				System.out.println("2 : " +result.getFieldError("content").getCode());
			}
			view = "insertForm";
		}
		
		return view;
	}

}
