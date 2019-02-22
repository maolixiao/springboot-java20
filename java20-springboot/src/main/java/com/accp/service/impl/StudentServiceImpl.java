package com.accp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.StudentMapper;
import com.accp.domain.Student;
import com.accp.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
@CacheConfig(cacheNames="student")
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentMapper mapper;
	
	@Cacheable(key="#p0")
	public PageInfo<Student> query(Integer currentPage,Integer pageSize){
		Page<Student> page = PageHelper.startPage(currentPage,pageSize,true);
		//true:是否需要查询总条数
		mapper.query();
		
		return page.toPageInfo();
	}
	
	@Cacheable(keyGenerator="keyGenerator")
	public List<Student> queryAll(){
		return mapper.query();
	}
	
	@CachePut(key="#p0.id")
	public Student add(Student stu) {
		//mapper.//将设添加数据库成功
		return stu;
	}
	
	
	@CachePut(key="#p0.id")
	public Student update(Student stu) {
		//mapper.//将设添加数据库成功
		return stu;
	}
	
	@CacheEvict(key="#p0")
	public void delete(int id) {
		
	}
	
	public Student queryByName(String name) {
		return mapper.queryByName(name);
	}
	
}
