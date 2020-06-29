package com.home.uhd.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.home.uhd.domain.ApplVO;
import com.home.uhd.mapper.RecrMapper;

@Controller
public class RecrContoller {
	
	private static final String UPLOAD_PATH = "file:///C:\\Users\\user\\Documents\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\Doc";
	
	@Autowired
	RecrMapper recrMapper;
	
	@GetMapping("/recruit")
	public String Recruit (Model model) {

		return "recruit/recruit"; // 커뮤니티 > select
	}
	
	@GetMapping("/hire")
	public String Hire (Model model) {

		return "recruit/hire"; // 커뮤니티 > select
	}
	
	
	@PostMapping("/recruit/application")
	public String Application(ApplVO vo, MultipartFile uploadfile) throws Exception {
		vo.setApplication_document(saveFile(uploadfile));  // 지원서류 파일 저장
		recrMapper.insertApplication(vo);
		return "recruit/hire";
	}
	
	private String saveFile(MultipartFile file) {
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + file.getOriginalFilename();


	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;		
	}
}
