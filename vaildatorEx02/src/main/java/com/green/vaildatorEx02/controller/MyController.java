package com.green.vaildatorEx02.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.vaildatorEx02.dto.ContentDto;
import com.green.vaildatorEx02.util.ContentValidator;

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
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ContentValidator());
	}
	
	//@InitBinder 어노테이션을 지정하여 해당 메서드를 프로젝트가 시작할 때 먼저 실행시킨다.
	//그러면 webDataBinder 타입 변수에 우리가 사용할 유효성 검증 클래스가 프로젝트 시작 시점에 등록된다.
	//이후에는 개별적으로 생성할 필요없이 유효성 검증이 필요하면 binder 변수에서 꺼내서 사용하면 된다.
	
	
	//@Valid 어노테이션으로 contentDto 객체 변수에 대한 유효성 검증을 하겠다는 표시를 한 것이다.
	//파라미터(폼데이터)로 객체 변수에 들어오면 스프링이 binder 변수에 저장된 객체(ContentValidator)를 
	//통해서 즉시 유효성 검사를 하고 에러가 있다면 result 변수(BindingResult)에 담아둔다. 
	
	//시사점 : 유효성 검사가 필요할때마다 33라인에서처럼 유효성 검사 객체를 생상하고,
	//34라인에서처럼 유효성 검사 메서드를 호출하는 것이 아니라...
	//29라인에서 보는 것처럼 유효성 검사가 필요한 변수에 @Valid 어노테이션만 붙여주면 유효성 검사를
	//수행하게 된다.

	
	
	
}
