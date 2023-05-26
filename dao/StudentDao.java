package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {
	
	HelperClass helperClass=new HelperClass();
     Connection connection=null;
     
     //
     public void addMultipleStudent(List<Student> students) {
    	 connection=helperClass.getConnection();
    	 String sql="INSERT INTO student VALUES(?,?,?)";
    	 
    	 try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			for(Student s: students) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("All good");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	 
    	 
     }
	  
	  
	  //get details of student using id
	  public Student getStudentsById(int id) {
		  connection=helperClass.getConnection();
		  String sql="SELECT * FROM student WHERE id=? ";
		  Student student2=new Student();
		  
		  try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//execute the statement
		ResultSet resultSet=	preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			int id2 =resultSet.getInt(1);
			String name=resultSet.getString(2);
			String email=resultSet.getString(3);
			
			student2.setName(name);
			student2.setId(id2);
			student2.setEmail(email);
			
		}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student2;
	  }
	  
	  
	  //update all
	  public boolean updateStudentById(int id, String email) {
	    	connection=  helperClass.getConnection();
			String sql="UPDATE student set email=? WHERE id=?";
			// create statement
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setInt(2, id);
				//execute statement
				preparedStatement.executeUpdate();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		
			
		}
	  
	  //get all
	  public List<Student> getAllStudents() {
		  connection=helperClass.getConnection();
		  String sql="SELECT * FROM student";
		  ArrayList<Student> al=null;
		  
		  try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			         //execute the query
			ResultSet resultSet=preparedStatement.executeQuery();
			al=new ArrayList<>();
			while(resultSet.next()) {
				int id =resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				Student s =new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				al.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
		
	}
	 
	  // delete the student
    public boolean deleteStudentById(int id) {
			connection=  helperClass.getConnection();
			String sql="DELETE FROM student WHERE id=?"; 
			boolean  res=false;
			
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				//Execute 
				int res2=preparedStatement.executeUpdate();
				if(res2>0) {
					res=true;
				}
				else {
					res=false;
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return res;
			
		  }
    
    
    
      //To save a student
	public Student  saveStudent(Student student){
		Connection connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)";
		
		//Create statement
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
			
			// Execute the statement
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return student;
		
	}
	
}
