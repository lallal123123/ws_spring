package com.example.jpaBbs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpaBbs.Repository.BoardRepository;
import com.example.jpaBbs.entity.Board;
import com.example.jpaBbs.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository br;
	
	@RequestMapping("/writeForm")
	public void writeForm() {
		
	}
	
	@RequestMapping("/write")
	public String write(Board board,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user= new User();
		user.setUsername((String)session.getAttribute("username"));
		board.setUser(user);
		System.out.println(board.getUser());
		br.save(board);
		
		return "redirect:main";
	}
	
	@RequestMapping("/main")
	public void main(Model model) {
		List<Board> list =br.findAll();
		model.addAttribute("list", list);
	
	}
	
	@RequestMapping("/detail")
	public void detail(@RequestParam("bno") Long bno,Model model) {
		Optional<Board> option =  br.findById(bno);
		Board board = option.get();
		model.addAttribute("board",board);
	}
}
