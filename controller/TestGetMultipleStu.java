package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestGetMultipleStu {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		ArrayList<Student> al=new ArrayList<>();

		
		Student s1=new Student();
		s1.setId(3);
		s1.setName("neha");
		s1.setEmail("neha@gmail.com");
		
		Student s2=new Student();
		s2.setId(4);
		s2.setName("kirti");
		s2.setEmail("kirti@gmail.com");
		
		Student s3=new Student();
		s1.setId(5);
		s1.setName("sonu");
		s1.setEmail("sonu@gmail.com");
		
		Student s4=new Student();
		s1.setId(6);
		s1.setName("kiwi");
		s1.setEmail("kiwi@gmail.com");
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		
		 
		studentDao.addMultipleStudent(al);
	}

}
