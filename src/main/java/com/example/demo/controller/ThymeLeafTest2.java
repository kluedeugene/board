package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeLeafTest2 {
//	@RequestMapping("/{number}")
	public String index(@PathVariable int number, Model model) {
		model.addAttribute("pow", number*number);
		return "index";
	}
}
