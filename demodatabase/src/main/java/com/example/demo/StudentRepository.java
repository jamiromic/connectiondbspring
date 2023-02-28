package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,
Integer> {
	
	Student findById(int id);
    List<Student> findAll();
    void deleteById(int id);
	
	
	

}
