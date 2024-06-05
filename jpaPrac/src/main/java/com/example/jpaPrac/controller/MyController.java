package com.example.jpaPrac.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpaPrac.entity.Bbs;
import com.example.jpaPrac.repository.BbsRepository;

@Controller
public class MyController {
	
	@Autowired
	BbsRepository bs;
	@Autowired
	Bbs bbs;
	
	@RequestMapping("/")
	public String root(){
		return "index";
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		List<Bbs> list =bs.findAll();
		long bbsCnt =bs.count();
		model.addAttribute("list", list);
		model.addAttribute("bbsCnt", bbsCnt);
	}
	
	@RequestMapping("writeForm")
	public void writeForm() {
		
	}
	
	@RequestMapping("write")
	public String write(Bbs bbs ) {
		bs.save(bbs);
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("bno") String bno) {
	long bno_ = Long.parseLong(bno); 
		bs.deleteById(bno_);
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public void detail(@RequestParam("bno") String bno, Model model) {
		long bno_ = Long.parseLong(bno);
		Optional<Bbs> oBbs=  bs.findById(bno_);
		bbs = oBbs.get();
		model.addAttribute("bbs", bbs);
		
		
	}
	
	@RequestMapping("updateForm")
	public void updateForm(@RequestParam("bno") String bno, Model model) {
		long bno_ = Long.parseLong(bno);
		Optional<Bbs> oBbs=  bs.findById(bno_);
		bbs = oBbs.get();
		model.addAttribute("bbs", bbs);
		
		
	}
	
	@RequestMapping("update")
	public String update(Bbs bbs) {
		bs.save(bbs);
		
		return "redirect:list";
	}
	

}
