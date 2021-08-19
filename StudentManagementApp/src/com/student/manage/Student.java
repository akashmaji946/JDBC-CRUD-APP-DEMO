package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Student {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	
	// private properties
	private int studentId;
	private String studentName;
	private String studentCity;
	private int studentAge;
	private long studentPhone;
	
	// getters and setters
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}
	
	// constructors

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentAge, long studentPhone, String studentCity) {
		super();

		this.studentAge = studentAge;
		this.studentPhone = studentPhone;
		this.studentCity = studentCity;
	}
	
	public Student(int studentId, String studentName,
		       int studentAge, long studentPhone, String studentCity) {
	
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentAge = studentAge;
	this.studentPhone = studentPhone;
	this.studentCity = studentCity;
    }
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
				+ ", studentAge=" + studentAge + ", studentPhone=" + studentPhone + "]";
	}
	
	// 
    public static Student createStudent(int type) throws NumberFormatException, IOException {
		
    	int id = 0;
    	String name = null;
    	
		if(type == 0) { // when new student is to be created
			System.out.println("Enter id: ");
			 id = Integer.parseInt(br.readLine());
			
			System.out.println("Enter name:");
			 name = br.readLine();
			
			
		}
    	
		System.out.println("Enter age: ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.println("Enter phone:");
		long phone = Long.parseLong(br.readLine());
		
		System.out.println("Enter city: ");
		String city = br.readLine();
		
		
	
		 Student student ;
		   
		  
		  
		 if(type == 0) 
			 student = new Student(id, name, age, phone, city);
		 else 
			 student = new Student(age, phone, city);
		 
		return student;
	}

	
	
}
