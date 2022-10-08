package com.mizan.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
	@GetMapping
	public List<String> getStudents(){
		List<String> list = new ArrayList<>();
		list.add("Student1");
		list.add("Student2");
		return list;
	}

}
