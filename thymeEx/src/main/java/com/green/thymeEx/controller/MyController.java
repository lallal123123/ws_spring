package com.green.thymeEx.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.thymeEx.dto.SampleDto;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2	
public class MyController {

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/ex01")
	public void ex01(Model model) {		//void일땐 매핑 url과 똑같은 뷰가 있다고 생각하고 거기로 보내줌
		log.info("ex01..............");
		model.addAttribute("data", "서버에서 넘어온 데이터");
		//return "ex01";
	}
	
	@RequestMapping({"/ex02","/ex02_1","/ex03","/ex02_2","/exLink","/exLink2"})
	public void ex02(Model model) {
		List<SampleDto> list = IntStream.rangeClosed(1,10)	//스트림으로 만들어진 데이터는 일회용
				.mapToObj(i -> {		//화살표 함수 사용가능
			SampleDto dto = SampleDto.builder()
					.name("aaa_" + i)
					.age(20 + i)
					.regdate(LocalDate.now())
					.build();
			return dto;
		}).collect(Collectors.toList());
		
		for(SampleDto s : list) {
			log.info(s);
		}
		
		
		model.addAttribute("list", list);
		
		
	}
	
	@RequestMapping("/exInline")
	public String exInline(RedirectAttributes rttr) {	//리턴으로 redirect를 쓰면서 데이터 넘기고 싶을때 사용(Model로 안 옮겨짐)
		log.info("exInline......");
		
		SampleDto dto = SampleDto.builder()
				.name("hgd")
				.age(32)
				.build();
		
		rttr.addAttribute("result", "success");	//url에 실어 보냄
		rttr.addFlashAttribute("dto",dto);		//url에 노출 안시키고 사용(session 영역에 잠시 저장(계속 사용못함))
		
		return "redirect:ex04";
		
	}
	
	@GetMapping("/ex04")
	public void ex04() {
		log.info("ex04..........");
	}
	
	@GetMapping("/exView")
	public void exView(SampleDto dto,Model model) {
		model.addAttribute("dto",dto);
		
		
	}
	
	@GetMapping("/exViewPath/{name}/{age}/{date}")
	public String exView(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("date") LocalDate date, Model model) {
		model.addAttribute("name",name);
		//model.addAttribute("age",age);
		//model.addAttribute("date",date);
		
		return "exViewPath";
	}
	
	@GetMapping({"/exLayout1","/exLayout2"})
	public void exLayout() {
		log.info("exLayout............");
	}
	
	
	
	
}
