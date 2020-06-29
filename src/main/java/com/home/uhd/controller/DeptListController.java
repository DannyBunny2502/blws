package com.home.uhd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.uhd.domain.DeptVO;
import com.home.uhd.mapper.DeptMapper;

@RestController
public class DeptListController {
	@Autowired
	private DeptMapper deptMapper;
	
	@RequestMapping("/dept")
	public List<DeptVO> selectDeptList() throws Exception{
		System.out.println("go dept()");
		List<DeptVO> dept = deptMapper.selectDeptList();
		System.out.println("out dept()");
		return dept;
	}
}
