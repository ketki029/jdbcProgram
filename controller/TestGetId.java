package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestGetId {
public static void main(String[] args) {
	StudentDao studentDao=new StudentDao();
	Student s=studentDao.getStudentsById(2);
	System.out.println(s.getId());
	System.out.println(s.getName());
	System.out.println(s.getEmail());
}
}
