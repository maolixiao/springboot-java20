package com.accp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.Student;
import com.accp.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	StudentService service;
	
	@RequestMapping("/tologin")
	public String tologin(Integer type,Model model) {
		if(type!=null && type==1) {
			model.addAttribute("msg", "账户或者密码错误");
		}
		return "login/login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String userpwd,HttpSession session) {
		Student stu = service.queryByName(username);
		if(stu!=null) {
			session.setAttribute("user", stu);
			session.setMaxInactiveInterval(60*60);
			return "redirect:/test";
		}
		return "redirect:/tologin?type=1";
	}
}
