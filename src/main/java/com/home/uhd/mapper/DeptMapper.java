package com.home.uhd.mapper;

import java.util.List; //List 함수 사용을 위함

import com.home.uhd.domain.DeptVO; 

public interface DeptMapper {
	public List<DeptVO> selectDeptList() throws Exception;
}
