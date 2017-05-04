package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Student;
import com.example.repository.StudentMySqlRepository;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentMySqlRepository studentMySqlRepository;

	@Override
	public Student saveStudent(Student student) {
		Student createdEmployee =  studentMySqlRepository.save(student);
		if(createdEmployee.getId() == 6){
			throw new RuntimeException("Exception Occurred Roll backed....");
		}
		return createdEmployee;
	}

}
