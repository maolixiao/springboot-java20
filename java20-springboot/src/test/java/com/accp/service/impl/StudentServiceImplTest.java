package com.accp.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accp.domain.Student;
import com.accp.service.StudentService;
import com.github.pagehelper.PageInfo;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
	
	@Autowired
	StudentService service;
	
	
	@Before
	public void a() {
		
	}

	@Test
	public void testQuery() {
		//PageInfo<Student> page = service.query(1,2);
//		PageInfo<Student> page1 = service.query(1,2);
//		PageInfo<Student> page2 = service.query(1,2);
//		PageInfo<Student> page3 = service.query(1,2);
//		Student stu = new Student(2,"傻蛋");
//		service.update(stu);
		service.delete(2);
	}

}
