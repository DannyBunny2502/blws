package com.home.uhd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.uhd.domain.NewsVO;
import com.home.uhd.mapper.EnterMapper;

@Controller
public class EnterController {
	
	@Autowired
	private EnterMapper enterMapper;
	
	@GetMapping("/news")
	public String newsList (Model model) throws Exception {
		model.addAttribute("newsList", enterMapper.selectNewsList());
		return "enter/news";
	}
	
	@GetMapping("/news/write") //세션값 넘겨줘야함
	public String newsWriteGet (Model model) throws Exception {
		return "enter/news_write";
	}
	
	@PostMapping("/news/write")
	public String newsWritePost (Model model, NewsVO vo) throws Exception {
		
		enterMapper.insertNews(vo);
		return "redirect:/news"; //기업소개 목록으로 돌아감
	}
	
	@GetMapping("/news/read")
	public String newsRead (@RequestParam("news_no") int news_no, Model model) throws Exception {
		

		model.addAttribute("newsList", enterMapper. readNews(news_no));
		
		return "enter/news_read";
	}
	
	@GetMapping("/news/delete")
	public String newsDelete (@RequestParam("news_no") int news_no, Model model) throws Exception {
		
		enterMapper.deleteNews(news_no);
		return "redirect:/news"; //기업소개 목록으로 돌아감
	}
	
	@GetMapping("/news/modify")
	public String newsModifyGet (@RequestParam("news_no") int news_no, Model model) throws Exception {
		
		model.addAttribute("newsList", enterMapper.readNews(news_no));
		return "enter/news_modify"; //기업소개 목록으로 돌아감
	}
	
	@PostMapping("/news/modify")
	public String newsModifyPost (NewsVO vo, Model model) throws Exception {
		
		enterMapper.modifyNews(vo);
		return "redirect:/news/read?news_no="+vo.getNews_no(); //기업소개 목록으로 돌아감
	}
	
}
