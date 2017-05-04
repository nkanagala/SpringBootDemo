package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;
	
	// inserting Student.
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> createEmployee(@RequestBody Student student) throws Exception{
		
		Student s1 = new Student();
		s1.setName("Naresh");
		s1.setAddress("Hyderabad");
		Student createdStudent = studentService.saveStudent(s1);
			if (createdStudent != null) {
				return new ResponseEntity<Student>(createdStudent, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			}
	
	}
	
	
	// inserting Student.
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String test() throws Exception{
		
				return "Server Started";
	
	}


}
