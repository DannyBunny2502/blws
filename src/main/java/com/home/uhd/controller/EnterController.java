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
	
	@PostMappring("/news")
	public String newsListSearch(@RequestParam(defaultValue="news_contents") String keyword, @RequestParam(defaultValue="") String search) throws Exception{
		 //페이지 관련 설정, 시작번호와 끝번호를 구해서 각각 변수에 저장한다.
		int coount = 1000;
		
        Pager pager = new Pager(count, curPage);
        int start = pager.getPageBegin();
        int end =  pager.getPageEnd();
             
        //map에 저장하기 위해 list를 만들어서 검색옵션과 키워드를 저장한다.
        List<MemberBoardDTO> list = memberboardservice.listAll(search_option, keyword, start, end);
        
        ModelAndView mav = new ModelAndView();
        Map<String,Object> map = new HashMap<>();    //넘길 데이터가 많기 때문에 해쉬맵에 저장한 후에 modelandview로 값을 넣고 페이지를 지정
        
        map.put("list", list);                         //map에 list(게시글 목록)을 list라는 이름의 변수로 자료를 저장함.
        map.put("pager", pager);
        map.put("count", count);
        map.put("search_option", search_option);
        map.put("keyword", keyword);
        mav.addObject("map", map);                    //modelandview에 map를 저장
        
        System.out.println("map : "+map);
        mav.setViewName("board/memberboard");                //자료를 넘길 뷰의 이름
        
        return mav;    //게시판 페이지로 이동
	}
	
	@GetMapping("/news/write") //���ǰ� �Ѱ������
	public String newsWriteGet (Model model) throws Exception {
		return "enter/news_write";
	}
	
	@PostMapping("/news/write")
	public String newsWritePost (Model model, NewsVO vo) throws Exception {
		
		enterMapper.insertNews(vo);
		return "redirect:/news"; //����Ұ� ������� ���ư�
	}
	
	@GetMapping("/news/read")
	public String newsRead (@RequestParam("news_no") int news_no, Model model) throws Exception {
		

		model.addAttribute("newsList", enterMapper. readNews(news_no));
		
		return "enter/news_read";
	}
	
	@GetMapping("/news/delete")
	public String newsDelete (@RequestParam("news_no") int news_no, Model model) throws Exception {
		
		enterMapper.deleteNews(news_no);
		return "redirect:/news"; //����Ұ� ������� ���ư�
	}
	
	@GetMapping("/news/modify")
	public String newsModifyGet (@RequestParam("news_no") int news_no, Model model) throws Exception {
		
		model.addAttribute("newsList", enterMapper.readNews(news_no));
		return "enter/news_modify"; //����Ұ� ������� ���ư�
	}
	
	@PostMapping("/news/modify")
	public String newsModifyPost (NewsVO vo, Model model) throws Exception {
		
		enterMapper.modifyNews(vo);
		return "redirect:/news/read?news_no="+vo.getNews_no(); //����Ұ� ������� ���ư�
	}
	
}
