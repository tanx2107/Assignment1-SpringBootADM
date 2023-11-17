package com.example.demo.Service;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Student;

import java.util.ArrayList;


@Service
@Scope("prototype")
public class StudentService implements InitializingBean , DisposableBean {
	
	private List<Student> studentList;
	private Map<Integer, Student> studentMap = new HashMap();
	
	
	public void addStudent(Student student) {
		studentMap.put(student.getId(), student);
		System.out.println("Added student: "+student);		
	}
	
	public List<Student> getAllStudents(){
			return new ArrayList<>(studentMap.values()); 
		
	}
	public void updateScore(int id, int newScore) {
		if(studentMap.containsKey(id)) {
			Student student = studentMap.get(id);
			student.setScore(newScore);
			System.out.println("Updated score for student "+ id+ ": "+newScore);
			calculateScores(newScore);
		}
	}
	
	public void deleteStudent(int id) {
		if(studentMap.containsKey(id)){
			Student removeStudent= studentMap.remove(id);
			System.out.println("Removed values -"+ removeStudent);
		}
	}
	
	public void calculateScores(int score) {
		if (score < 50) {
			System.out.println("Below Average");
		} else if (score > 50 && score < 75) {
			System.out.println("Average");
		} else if (score > 75) {
			System.out.println("Above Average");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("StudentService has been initialized");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("StudentService is being destroyed");
		
	}
		public static void main(String[] args) {
		

	}
}
