package com.home.uhd.mapper;

import java.util.List; //List �Լ� ����� ����

import com.home.uhd.domain.DeptVO; 

public interface DeptMapper {
	public List<DeptVO> selectDeptList() throws Exception;
}
