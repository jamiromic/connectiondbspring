package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	//Questa è una dependencyInjection in cui iniettiamo nella classe StudentController un istanza della classe
	//StudentRepository
	@Autowired
    private StudentRepository studentrepo;
    
	// Home Page
    @GetMapping("/")
    public String welcome()
    {
        return "<html><body>"
            + "<h1>WELCOME</h1>"
            + "<a href=http://localhost:8080/api/student>Elenco studenti</a>"
            + "</body></html>";
    }
  
    // Get All Students
    @GetMapping("/student")
    public List<Student> getAllStudents()
    {
        return studentrepo.findAll();
    }
    
    public String buttonDelete() {
    	return "<html><body>"
                + "<h1>Ciao</h1>"
                + "</body></html>";
    }
  
    // Get the student details by
    // ID
    @GetMapping("/student/{id}")
    public Student getStudentById(
        @PathVariable(value = "id") int id)
    { 	
        return studentrepo.findById(id);
    }
  
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(
        @RequestBody Student student)
    {
        return studentrepo.save(student);
    }
  
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(
        @PathVariable(value = "id") int id)
    {
        studentrepo.deleteById(id);
    }
  
    @PutMapping("/student/{id}")
    public ResponseEntity<Object> updateStudent(
        @RequestBody Student student,
        @PathVariable int id)
    {
  
        Optional<Student> studentRepo
            = Optional.ofNullable(
                studentrepo.findById(id));
  
        if (!studentRepo.isPresent())
            return ResponseEntity
                .notFound()
                .build();
  
        student.setId(id);
  
        studentrepo.save(student);
  
        return ResponseEntity
            .noContent()
            .build();
    }

}
