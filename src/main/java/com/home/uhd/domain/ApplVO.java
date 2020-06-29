package com.home.uhd.domain;

import lombok.*;

@Data

public class ApplVO {
	private int application_no;
	private String application_career;
	private String application_filed;
	private String application_name;
	private String application_email;
	private String application_date;
	private String application_document;
	public int getApplication_no() {
		return application_no;
	}
	public void setApplication_no(int application_no) {
		this.application_no = application_no;
	}
	public String getApplication_career() {
		return application_career;
	}
	public void setApplication_career(String application_career) {
		this.application_career = application_career;
	}
	public String getApplication_filed() {
		return application_filed;
	}
	public void setApplication_filed(String application_filed) {
		this.application_filed = application_filed;
	}
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	public String getApplication_email() {
		return application_email;
	}
	public void setApplication_email(String application_email) {
		this.application_email = application_email;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getApplication_document() {
		return application_document;
	}
	public void setApplication_document(String application_document) {
		this.application_document = application_document;
	}

	
	
}
