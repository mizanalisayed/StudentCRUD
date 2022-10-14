package com.mizan.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	//List All
	public Iterable<Student> getAll(){
		return studentRepository.findAll();
	}
	
	//Create
	public String createStudent(String name , String email) {
		Student student = new Student();
		student.setEmail(email);
		student.setName(name);
		studentRepository.save(student);
		return "Created";
		
	}
	
	//Read
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
		
	}
	
	//Update
	public String updateStudent(Integer id, String name , String email) {
		Student student = studentRepository.findById(id).get();
		student.setEmail(email);
		student.setName(name);
		studentRepository.save(student);
		return "Updated";
	}
	
	//Delete
	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return "Deleted";
	}
}
