package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Member;
import com.example.demo.repositories.MyRepository;

@Controller
public class EditTest {
    
    @Autowired
    MyRepository repository;

    @GetMapping("edit/{id}")
    public ModelAndView editForm( @ModelAttribute("formModel") Member member, ModelAndView mav, @PathVariable long id  ) {

        mav.setViewName("editTest");
        member = repository.findById(1);
        mav.addObject("formModel", member);

        return mav;
    }
        
    @PostMapping("edit")
    @Transactional
    public ModelAndView update(@ModelAttribute("formModel") Member member, ModelAndView mav) {
        repository.saveAndFlush(member);
        return new ModelAndView("redirect:/repository");
    }
    
    @PostMapping("delete")
    @Transactional
    public ModelAndView remove(@RequestParam long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/repository");
    }
    
}
