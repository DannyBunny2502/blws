package com.home.uhd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.uhd.domain.CommVO;
import com.home.uhd.mapper.CommMapper;
import com.home.uhd.mapper.DeptMapper;

@Controller
public class CommController {
	
	@Autowired
	private CommMapper commMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	
	@GetMapping("/community")
	public String CommunityList (Model model) throws Exception {
		model.addAttribute("deptList", deptMapper.selectDeptList());
		return "community/list"; // Ŀ�´�Ƽ > select
	}
	
	@GetMapping("/community/write")
	public String CommunityWrite () {
		System.out.println("get write");
		return "community/write"; // �۾��� ������
	}
	
	@PostMapping("/community/write")
	public String CommunityWrite (CommVO commVO) throws Exception{
		commMapper.insertComm(commVO);
		System.out.println(commVO);
		System.out.println("post write");
		return "redirect:../community"; // �� �ۼ� �� ������� ���ư� > Insert
	}
}
