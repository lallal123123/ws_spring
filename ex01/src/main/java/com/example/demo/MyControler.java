package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Member;
@Controller
public class MyControler {

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("name", "일지매");
		
		return "test1";
	}
	//test2는 폴더안의 경로의 test2 찾아가기(주소엔 test2만 넣고)
	@RequestMapping("/test2")
	public String test2() {
		return "/sub/test2";
	}

	//test3은 모델앤뷰를 써서 보기
	@RequestMapping("/test3")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		mv.addObject("lists", list);
		mv.addObject("name", "일지매");
		mv.setViewName("/test3");
		
		return mv;
	}
	
	//test4는 폼으로 데이터 받아서 request,model 써서 넘기기
	
	@RequestMapping("/form")
	public String form() {
		
		return "form";
	}
	

	
	@RequestMapping("/test4")
	public String test4(HttpServletRequest request,Model model) {
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("name",request.getParameter("name"));
		return "test4";
	}

	//test5는 어노테이션으로 각각 파라미터받기
	@RequestMapping("/test5")
	public String test5(@RequestParam("id") String id ,@RequestParam("name") String name , Model model) {
			model.addAttribute("id",id);
			model.addAttribute("name",name);
			return "test5";
	}
	

	//커맨드 객체를 이용해서 파라미터 받기
	@RequestMapping("/test6")
	public String test6(Member member) {
		
		return "test6";
		
	}
	
	//주소창으로 파라미터 실어보내기
	@RequestMapping("/test7/{sid}/{name}")
	public String test7(@PathVariable String sid,@PathVariable String name, Model model) {
		
		model.addAttribute("id", sid);
		model.addAttribute("name",name);
		
		return "test7";
	}
	
	//
	@RequestMapping("/test8")
	public String test8(@RequestParam("id") String id,@RequestParam("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name",name);
		
		return "test8";
	}
	
	@RequestMapping("/test10")
	public @ResponseBody String test9(@RequestParam("sid") String sid){
		Member member1 = new Member();
		member1.setId("hgd");
		member1.setName("홍길동");
		Member member2 = new Member();
		member2.setId("IGJ");
		member2.setName("임꺽정");
		String msg="";
		if(sid.equals(member1.getId()) || sid.equals(member2.getId())) {
			msg="이미 등록된 아이디입니다.";
		}else {
			msg="사용가능한 아이디입니다.";
		}
		return msg;
	}
	
	@RequestMapping("/test9")
	public String test9() {
		
		
		return "/test9";
	}
	
	@RequestMapping("/test11")
	public @ResponseBody Member test11(){
		Member member = new Member();
		member.setId("hrd");
		member.setName("홍길동");
		
		return member;
	}
	@RequestMapping("/test12")
	public @ResponseBody List<Member> test12(){
		Member member1 = new Member();
		member1.setId("hrd");
		member1.setName("홍길동");
		Member member2 = new Member();
		member2.setId("IGJ");
		member2.setName("임꺽정");
		
		List<Member> mlist= new ArrayList<>();
		mlist.add(member1);
		mlist.add(member2);
		return mlist;
	}
}
