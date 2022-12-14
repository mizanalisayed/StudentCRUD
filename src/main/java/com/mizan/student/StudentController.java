package com.mizan.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path="/student")
	 public @ResponseBody String addNewStudent (@RequestParam String name
		      , @RequestParam String email) {
		    // @ResponseBody means the returned String is the response, not a view name
		    // @RequestParam means it is a parameter from the GET or POST request
			return studentService.createStudent(name, email);
		  }
	
	
	@GetMapping(path="/students")
	  public @ResponseBody Iterable<Student> getAllStudent() {
	    // This returns a JSON or XML with the users
	    return studentService.getAll();
	  
	}
	@GetMapping(path="/student")
	public @ResponseBody Student getStudent(@RequestParam Integer id) {
		return studentService.getStudent(id);
	}
	
	@PutMapping(path="/student")
	public @ResponseBody String updateStudent(@RequestParam Integer id ,@RequestParam String name
			, @RequestParam String email) {
		
		return studentService.updateStudent(id, name, email);
	}
	
	@DeleteMapping(path="/student")
	public @ResponseBody void deleteStudent(@RequestParam Integer id) {
		studentService.deleteStudent(id);
	}

}
