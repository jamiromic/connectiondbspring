package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//Questa è una dependencyInjection in cui iniettiamo nella classe StudentController un istanza della classe
	//StudentService
	
	@Autowired
    private StudentService studentService;
    
	//Endpoint HTTP
	
	//Con GetMapping diciamo che il metodo gestisce le richieste di tipo Get a quest'url
	//endpoint HTTP che restituisce un elenco di studenti come risposta a una richiesta HTTP GET all'URL "/studenti".
	//La lista di studenti viene ottenuta invocando il metodo trovaTutti() dell'oggetto studentService. 
	//La risposta HTTP ha un codice di stato HTTP 200 (OK) e il corpo della risposta contiene la lista di studenti.
	
	@GetMapping("/studenti")
	public ResponseEntity<List<Student>> trovaTutti() {
        List<Student> studenti = studentService.trovaTutti();
        return new ResponseEntity<List<Student>>(studenti, HttpStatus.OK);
    }

}
