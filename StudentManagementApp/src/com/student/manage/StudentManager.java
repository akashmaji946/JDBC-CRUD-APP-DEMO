package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class StudentManager {
	public static boolean addStudent(Student s) {
		
		boolean success = false;
		
		try {
			
			Connection con = ConnectionCreator.createCon();
			String query = "INSERT INTO Students(sname, sid, sphone, sage, scity)"
					+ " VALUES(?, ?, ?, ?, ?)";
			
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, s.getStudentName());
			pstmt.setInt(2, s.getStudentId());
			pstmt.setLong(3, s.getStudentPhone());
			pstmt.setInt(4, s.getStudentAge());
			pstmt.setString(5, s.getStudentCity());
			
			pstmt.executeUpdate();
			
			success = true;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return success;
	}

	public static boolean removeStudent(int id) {
		boolean removed = false;
		
		try {
			Connection con = ConnectionCreator.createCon();
			String query = "DELETE FROM Students WHERE sid = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			removed = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return removed;
	}

	public static boolean updateStudent(int studentId) {
		
		boolean updated = false;
		
		
		
		try {
			
			Student s = Student.createStudent(1);
			
			Connection con = ConnectionCreator.createCon();
			String query = "UPDATE Students SET sage = ?, sphone = ?, scity = ? WHERE sid = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, s.getStudentAge());
			pstmt.setLong(2, s.getStudentPhone());
			pstmt.setString(3, s.getStudentCity());
			pstmt.setInt(4, studentId);
			
			pstmt.executeUpdate();
			
			updated = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return updated;
	}

	public static void showAll() {
		
		try {

			Connection con = ConnectionCreator.createCon();
			String query = "SELECT * FROM Students";
			
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(query);
			
			System.out.println("The students are:");
			System.out.println("------------------------------------");
			
			while(results.next()) {
				
				 String name = results.getString(1);
				 int id = results.getInt(2);
				 long phone = results.getLong(3);
				 int age = results.getInt(4);
				 String city = results.getString(5);
				 
				 Student student = new Student(id, name, age, phone, city);
				 System.out.println(student);
				 System.out.println("------------------------------------");
				 
				 
				 
				 
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
