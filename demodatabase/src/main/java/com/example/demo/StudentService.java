package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	public java.util.Optional<Student> getById(Long id) {
		return studentRepository.findById(id);
	}
	
	public Student createStud(Student student) {
		return studentRepository.save(student);
	}
	
	public void delete(Student student) {
        studentRepository.delete(student);
    }
    
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
	
	

}
