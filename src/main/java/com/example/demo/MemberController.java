package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.MemberDataRepository;

@Controller
public class MemberController {

	@Autowired
	MemberDataRepository repository;
	   
	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {
	  mv.setViewName("/index");
	  mv.addObject("data", repository.findAll());
	  return mv;
	}
}
