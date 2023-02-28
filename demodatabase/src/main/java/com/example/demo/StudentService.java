package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	//Dependency Injection
	 @Autowired
	    private StudentRepository studentRepository;
        
	    //Questo metodo ritorna una lista di studenti che va a recuperare dal repository
	    public List<Student> trovaTutti() {
	        return studentRepository.findByName("Michele");
	    }

}
