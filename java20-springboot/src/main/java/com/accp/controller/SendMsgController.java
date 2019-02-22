package com.accp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Student;
import com.accp.handler.MyWebSocketHandler;

@Controller
public class SendMsgController {
	
	@Autowired
	MyWebSocketHandler handler;

	
	/**
	 * 
	 * @param uid 发给谁的 143
	 * @param msg 发什么内容
	 * @return
	 */
	@RequestMapping("/sendMsg")
	@ResponseBody//（StringMessageConverter）(FastjsonMessageConverter)
	public String sendMsg(String uid,String msg,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String status = handler.sendMsg(uid, msg);
		Student stu = new Student();
		stu.setName(status);
		return status;
	}
	
}
