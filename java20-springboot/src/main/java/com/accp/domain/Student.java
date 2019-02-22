package com.accp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8937369337918862376L;
	
	private int id;
	private String name;
	private Date birthday;
	List<Student> list;
	
	
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Student(int id, String name, Date birthday, List<Student> list) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.list = list;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
