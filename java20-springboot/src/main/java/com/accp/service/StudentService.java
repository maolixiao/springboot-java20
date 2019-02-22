package com.accp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import com.accp.domain.Student;
import com.github.pagehelper.PageInfo;


public interface StudentService {
	public Student queryByName(String name);
	public PageInfo<Student> query(Integer currentPage,Integer pageSize);
	
	public List<Student> queryAll();
	
	public Student add(Student stu);
	
	public Student update(Student stu);
	
	public void delete(int id) ;
}
