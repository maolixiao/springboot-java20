package com.accp.webservice;

import java.util.List;

import javax.jws.WebService;

import com.accp.domain.Student;

@WebService(targetNamespace="http://webservice.accp.com")
public interface MyWebService {

	public List<Student> queryAll();
	
}
