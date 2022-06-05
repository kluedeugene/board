package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeLeafTest3 {
//	@RequestMapping("/{number}")
	public ModelAndView index(@PathVariable int number
			, ModelAndView mav) {
		mav.addObject("pow", number * number);
		mav.setViewName("powTemplate2");
		return mav;
	}
}