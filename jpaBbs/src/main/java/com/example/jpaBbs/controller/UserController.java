package com.example.jpaBbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jpaBbs.Repository.UserRepository;
import com.example.jpaBbs.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	
	@RequestMapping("/regForm")
	public void regForm() {
		
	}
	
	@RequestMapping("/reg")
	public String reg(User user,HttpServletRequest request) {
		
		User result =ur.save(user);
		if(result != null) {
			HttpSession session =request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("username", user.getUsername());
			return "redirect:/board/main";
		}
		
		return "regForm";
	}
	
	@RequestMapping("/loginForm")
	public void loginForm() {
		
	}
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request) {
		User result =ur.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(result != null) {
			HttpSession session =request.getSession();
			session.setAttribute("name", result.getName());
			session.setAttribute("username", result.getUsername());
			System.out.println(session.getAttribute("name"));
			return "redirect:/board/main";
		}
		
		return "loginForm";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session =request.getSession();
		session.invalidate();
		return "redirect:/";
	}

}
