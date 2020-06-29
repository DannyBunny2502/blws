package com.home.uhd.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class CommVO {
	private int comm_id;
	private String author;
	private String category;
	private String title;
	private String content;
	private String date;
	private int view;
	private String attach;
	private int up;
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	
	
}
