package com.velocity.chaitali.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velocity.chaitali.entity.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

	public List<Student> findByName(String name);
	public List<Student> findByCity(String city);
	//public void saveStu(Student student);
	public void deleteById(Integer id);
	
	//@Query(value = "select * from student where mobileNumber>= :mobileNumber", nativeQuery = true)
	//public List<Student> findByMobileNumber(@Param("mobileNumber") Integer mobileNumber);
	
	

	
}
