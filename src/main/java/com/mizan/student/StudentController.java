package com.mizan.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping(path="/add")
	 public @ResponseBody String addNewStudent (@RequestParam String name
		      , @RequestParam String email) {
		    // @ResponseBody means the returned String is the response, not a view name
		    // @RequestParam means it is a parameter from the GET or POST request

		    Student n = new Student();
		    n.setName(name);
		    n.setEmail(email);
		    studentRepository.save(n);
		    return "Saved";
		  }
	
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Student> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return studentRepository.findAll();
	  
	}

}
