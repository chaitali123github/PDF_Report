package com.velocity.chaitali.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import com.velocity.chaitali.entity.Student;
import com.velocity.chaitali.repo.IStudentRepo;

@Component
public class ApplicationRunner implements CommandLineRunner {

	public static void main(String[] args) {
  	  SpringApplication.run(ApplicationRunner.class, args);
	
}
		@Autowired
		private IStudentRepo repository;

		@Override
		public void run(String...args) {
	    System.out.println("Runner.......");

	    List<Student> stuList = List.of(new Student("Chaitali", "Pune", "123456789"), 
	    		new Student("Pranjali", "Washim", "456789123"),
	    		new Student("Mrunali", "Chandrapur", "789123456"),
	    		new Student("Ashutosh", "Gadchiroli", "159478236"),
	    		new Student("Rahul", "Pune", "15932636"),
	    		new Student("Seema", "Gadchiroli", "93218236"),
	    		new Student("Sachin", "Mumbai", "802359411"));
	      
	    repository.saveAll(stuList);
	      

	  

		}
}

