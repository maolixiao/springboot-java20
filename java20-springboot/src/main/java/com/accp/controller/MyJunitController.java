package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Student;
import com.accp.service.StudentService;

@Controller
public class MyJunitController {
	@Autowired
	StudentService service;
	
	@RequestMapping("/query")
	public String view(Model model,Student stu) {
		System.out.println(stu.getName());
//		List<Student> list = service.query(1,2);
//		model.addAttribute("stus", list);
		model.addAttribute("name","唐勇");
		return "student/query";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<Student> json(Student stu){
		return null;//service.query(1,2);
	}
	
	
	@RequestMapping("/jsonRequestBody")
	@ResponseBody
	public List<Student> jsonRequestBody(@RequestBody Student stu){
		return null;//service.query(1,2);
	}
	
}
