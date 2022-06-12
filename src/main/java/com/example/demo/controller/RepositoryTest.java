package com.example.demo.controller;

import com.example.demo.Member;
import com.example.demo.repositories.MyRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class RepositoryTest {
 	
	@PostConstruct	//예시 데이터 생성
	public void init(){
		Member member1 = new Member();
		member1.setId(1);
		member1.setName("shane");
		member1.setMemo("first member");
		repository.saveAndFlush(member1);
		Member member2 = new Member();
		member2.setId(2);
		member2.setName("jenny");
		member2.setMemo("second member");
		repository.saveAndFlush(member2);
		Member member3 = new Member();
		member3.setId(3);
		member3.setName("jane");
		member3.setMemo("third member");
		repository.saveAndFlush(member3);
	}


	@Autowired
	MyRepository repository;
	
	@GetMapping("repository")
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("repositoryTest");
		Iterable<Member> list = repository.findAll();
		mav.addObject("data", list);

		return mav;
	}
	
	@PostMapping("repository")	//member객체를 ModelAttribute로 받아서 repository에 저장
	@Transactional
	public ModelAndView form(
			@ModelAttribute("formModel") Member member, ModelAndView mav) {
		repository.saveAndFlush(member);
		return new ModelAndView("redirect:/repository");
	}
	
}

