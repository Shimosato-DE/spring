package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Spring Boot＋で”Hello World”を作成する
@Controller
public class HelloWorldController {
	@GetMapping("/")
	public String helloWorld(Model model) {
		
		model.addAttribute("message", "HelloWorld");
		
		return "index";
	}
	

}
