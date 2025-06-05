package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.serchAll();
		
		model.addAttribute("userlist", userlist);
		
		return "user/list";
	}
	

}
