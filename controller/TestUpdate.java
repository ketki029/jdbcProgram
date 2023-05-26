package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestUpdate {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		String email="kiwi@gmail.com";
		boolean flag=studentDao.updateStudentById(2,email );
		System.out.println(flag);
	}

}