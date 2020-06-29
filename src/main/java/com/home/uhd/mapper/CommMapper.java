package com.home.uhd.mapper;

import java.util.List; //List 함수 사용을 위함

import com.home.uhd.domain.CommVO; 

public interface CommMapper {
	public List<CommVO> selectComm() throws Exception;
	
	public void insertComm(CommVO commVO) throws Exception;
	
}
