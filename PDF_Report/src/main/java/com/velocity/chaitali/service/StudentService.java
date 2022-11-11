package com.velocity.chaitali.service;

import java.util.List;
import com.velocity.chaitali.entity.Student;

public interface StudentService {

	
		//Get
		public List<Student> getAllStu();
		public List<Student> getByName(String name);
	    public List<Student> getByCity(String city);
		//SaveAll
		public void saveStu(Student student);
		
		//Delete
		public void deleteById(Integer id);
		
		
	}


