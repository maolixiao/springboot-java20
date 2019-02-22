package com.accp.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accp.domain.Student;
import com.accp.service.StudentService;
import com.accp.webservice.MyWebService;

@WebService(targetNamespace="http://webservice.accp.com",
	endpointInterface="com.accp.webservice.MyWebService")
@Component
public class MyWebServiceImpl implements MyWebService {
	
	@Autowired
	StudentService studentService;
	
	public List<Student> queryAll(){
		return studentService.queryAll();
	}

}
