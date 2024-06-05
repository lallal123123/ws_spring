package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Member;

@Controller		//서블릿으로 만들어 줌
public class MyController {

	@RequestMapping("/")	//서비스 메서드를 대신 사용 , getMapping,postMapping도 있음
	public String root() {		//responseBody 화면에 제공하는 것 ( ajax에서 많이 사용 페이지를 보내는게 아니라 문자열만 보내니깐 )
		
		return "index";		//responseBody가 안붙었으니깐 페이지로 이동
	}
	
	@RequestMapping("/test1")			//Model model 객체가 미리 만들어지는것도 해줌
	public String test1(Model model) {	//request영역에 데이터를 심어 보내던것을 Model에 심어보냄
		
		model.addAttribute("name","홍길동");		//request.setAttribute()대신에 사용
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		
		return "/sub/test2";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test3(){
		
		ModelAndView mv =new ModelAndView();
		List<String> list = new ArrayList<>();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");

		mv.addObject("lists", list);
		mv.addObject("ObjectTest","테스트입니다.");
		mv.addObject("name","홍길동");
		mv.setViewName("view/myView");
		
		return mv;
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	
	
	@RequestMapping("/test4")
	public String test4(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		
		return "test4";
		
	}
	@RequestMapping("/test5")
	public String test5(@RequestParam("id") String id,@RequestParam("name") String name, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "test5";
	}
	
	@RequestMapping("/test6")
	public String test6(Member member,Model model) {
		
		System.out.println(member.getId());
		System.out.println(member.getName());
		return "test6";
	}
	
	@RequestMapping("/test7/{studentId}/{name}")
	public String getStudent(@PathVariable String studentId,@PathVariable String name, Model model) {
		
		model.addAttribute("id", studentId);
		model.addAttribute("name",name);
		
		return "test7";
	}
	
	
	
}
