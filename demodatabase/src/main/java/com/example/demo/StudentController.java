package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
    private StudentService studentService;
    
	@GetMapping("/studenti")
	public ResponseEntity<List<Student>> trovaTutti() {
        List<Student> studenti = studentService.trovaTutti();
        return new ResponseEntity<List<Student>>(studenti, HttpStatus.OK);
    }

}
