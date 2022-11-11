package com.velocity.chaitali.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velocity.chaitali.entity.Student;
import com.velocity.chaitali.repo.IStudentRepo;
@Service
public class StudentServiceImpl implements StudentService {


private final IStudentRepo repository;

@Autowired
public StudentServiceImpl(IStudentRepo repository) {
	this.repository = repository;
}

@Override
public List<Student> getAllStu() {
	Iterable<Student> list = repository.findAll();
	List<Student> stulist = new ArrayList<Student>();
	list.forEach(x -> stulist.add(x));
	return stulist;
}

@Override
public List<Student> getByName(String name) {
	return repository.findByName(name);
}

@Override
public List<Student> getByCity(String city) {
	return repository.findByCity(city);
}




@Override
public void deleteById(Integer id) {
	repository.deleteById(id);
	
}

@Override
public void saveStu(Student student) {
	repository.save(student);
	
}


	
	
}



