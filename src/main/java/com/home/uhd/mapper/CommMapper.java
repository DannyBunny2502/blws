package com.home.uhd.mapper;

import java.util.List; //List �Լ� ����� ����

import com.home.uhd.domain.CommVO; 

public interface CommMapper {
	public List<CommVO> selectComm() throws Exception;
	
	public void insertComm(CommVO commVO) throws Exception;
	
}
