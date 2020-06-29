package com.home.uhd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.uhd.mapper.EnterMapper;
@Controller
@RequestMapping(value="/")
public class MainController {
	
	@Autowired
	private EnterMapper enterMapper;
	
	@GetMapping("/")
	public String main (Model model) throws Exception {
		model.addAttribute("newsList", enterMapper.selectNewsList());
		return "index"; //html name
	}

}
