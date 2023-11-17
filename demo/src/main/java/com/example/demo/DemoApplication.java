package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entities.Student;
import com.example.demo.Service.StudentService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		StudentService student = new StudentService();
		
		 
		student.addStudent(new Student(1, "Tanmay", 80));
		student.addStudent(new Student(2, "Nikhil", 50));
		
		student.getAllStudents();
		
		
		student.updateScore(1,70);
		student.updateScore(2,30);
		student.calculateScores(1);
		student.deleteStudent(1);
		
	
	}
		
		
	}


