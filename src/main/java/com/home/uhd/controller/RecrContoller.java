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
	
	private static final String UPLOAD_PATH = "C:\\Users\\solda\\Documents\\files";
	
	@Autowired
	RecrMapper recrMapper;
	
	@GetMapping("/recruit")
	public String Recruit (Model model) {

		return "recruit/recruit"; // Ŀ�´�Ƽ > select
	}
	
	@GetMapping("/hire")
	public String Hire (Model model) {

		return "recruit/hire"; // Ŀ�´�Ƽ > select
	}
	
	
	@PostMapping("/recruit/application")
	public String Application(ApplVO vo, MultipartFile uploadfile) throws Exception {
		vo.setApplication_document(saveFile(uploadfile));  // 파일명 저장
		recrMapper.insertApplication(vo);
		return "recruit/hire";
	}
	
	private String saveFile(MultipartFile file) {
		// ���� �̸� ����
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + file.getOriginalFilename();


	    // ������ File ��ü�� ����(������ ����)
	    File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	    try {
	        file.transferTo(saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;		
	}
}
