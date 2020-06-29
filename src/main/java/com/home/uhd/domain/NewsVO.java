package com.home.uhd.domain;

import lombok.*;

@Data

public class NewsVO {
	private int news_no;
	private String news_title;
	private String news_author;
	private String news_contents;
	private String news_date;
	private String news_attach;
	private String news_attach_type;
	private int news_view;
	public int getNews_no() {
		return news_no;
	}
	public void setNews_no(int news_no) {
		this.news_no = news_no;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_author() {
		return news_author;
	}
	public void setNews_author(String news_author) {
		this.news_author = news_author;
	}
	public String getNews_contents() {
		return news_contents;
	}
	public void setNews_contents(String news_contents) {
		this.news_contents = news_contents;
	}
	public String getNews_date() {
		return news_date;
	}
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}
	public String getNews_attach() {
		return news_attach;
	}
	public void setNews_attach(String news_attach) {
		this.news_attach = news_attach;
	}
	public String getNews_attach_type() {
		return news_attach_type;
	}
	public void setNews_attach_type(String news_attach_type) {
		this.news_attach_type = news_attach_type;
	}
	public int getNews_view() {
		return news_view;
	}
	public void setNews_view(int news_view) {
		this.news_view = news_view;
	}

	
}
