package com.home.uhd.mapper;

import java.util.List; //List �Լ� ����� ����
import com.home.uhd.domain.NewsVO; 

public interface EnterMapper {
	public List<NewsVO> selectNewsList() throws Exception;
	public void insertNews(NewsVO vo) throws Exception;
	public NewsVO readNews(int news_no) throws Exception;
	public void deleteNews(int news_no) throws Exception;
	public void modifyNews(NewsVO vo) throws Exception;
}
