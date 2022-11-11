package com.velocity.chaitali.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.velocity.chaitali.entity.Student;
import com.velocity.chaitali.repo.IStudentRepo;
import com.velocity.chaitali.service.StudentServiceImpl;
import com.velocity.chaitali.util.PdfReportGenerator;

@RestController
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	private IStudentRepo service;
	@Autowired
	private IStudentRepo repository;
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return service.findAll();	
	}
	@GetMapping("/byname")
	public List<Student> getByName(@RequestParam String name){
		return service.findByName(name);
	}
	@GetMapping("/bycity")
	public List<Student> getByCity(@RequestParam String city ){
		return service.findByCity(city);
	}
	@PostMapping("/save")
	public String saveStu(@RequestBody Student student){
		service.save(student);
		 return "Record saved";
	}
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return "Record is deleted...";
	}
	
	@GetMapping("/export/pdf")
	public void exportToPdf(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

		String string = df.format(new Date());

		String headerKey = "Content-Disposition";

		String headerValue = "attachment; filename=student" + string + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Student> list = service.findAll();
		PdfReportGenerator pg = new PdfReportGenerator(list);

		pg.generate(list,response);
		
}
	
}
