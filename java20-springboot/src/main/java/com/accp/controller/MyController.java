package com.accp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Student;
import com.accp.properties.YTangProperties;
import com.accp.service.StudentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

//@RestController 
@Controller
public class MyController {
	private static final Log logger = LogFactory
			.getLog(MyController.class);
	@Autowired
	YTangProperties properties;
	
	
	@Value("${web.upload1}")
	private String name;

	@Autowired
	StudentService service;

	@RequestMapping("/test")
	public String test(Model model) {
		PageInfo<Student> list = service.query(1,2);
		model.addAttribute("stus", list);
		return "student/query";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {
		return "student/delete";
	}

	@RequestMapping("/upload")
	@ResponseBody
	public int upload( MultipartFile file1, 
			 MultipartFile file2,
			 MultipartFile file3, 
			 MultipartFile file4,
			 MultipartFile file5,String stu) {
		System.out.println(stu);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Student s = mapper.readValue(stu, Student.class);
			System.out.println(s.getList().get(0).getName());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
