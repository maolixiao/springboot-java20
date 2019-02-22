package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.accp.domain.Student;

@Mapper
public interface StudentMapper {
	public List<Student> query();
	
	public Student queryByName(String name);
}
