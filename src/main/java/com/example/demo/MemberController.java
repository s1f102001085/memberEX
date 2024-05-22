package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.MemberData;
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
	
	@PostMapping("/")
	  public ModelAndView find(ModelAndView mv,@RequestParam("find") String find) {
		List<MemberData> list;
		list = repository.findByNameLike("%" + find + "%");
	    mv.setViewName("/index");
		mv.addObject("data", list);
	    return mv;
	 }
	
	@GetMapping("/edit")
	public ModelAndView edit(ModelAndView mv) {
	  mv.setViewName("/edit");
	  mv.addObject("data", repository.findAll());
	  return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(ModelAndView mv) {
		mv.setViewName("/add");
		return mv;
	}
	
	@PostMapping("/add")
	public String add(MemberData data) {
		repository.saveAndFlush(data);
		return "redirect:/edit";
	}
	
	@GetMapping("/update")
	  public ModelAndView update(ModelAndView mv, @RequestParam("id") int id) {
	    mv.setViewName("/update");
	    mv.addObject("msg", "ID=" + id + " の登録情報を更新します。");
	    Optional<MemberData> form = repository.findById(id);
	    mv.addObject("form", form.orElse(new MemberData()));
	    return mv;
	}
	
	@PostMapping("/update")
	public String update(MemberData data) {
		repository.saveAndFlush(data);
		return "redirect:/edit";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		Optional<MemberData> data = repository.findById(id);
		repository.delete(data.get());
		return "redirect:/edit;";
	}
}
