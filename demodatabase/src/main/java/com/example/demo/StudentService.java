package com.example.demo;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	public Student getById(int id) {
		return studentRepository.findById(id);
	}
	
	public Student createStud(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(int id, Student studentDetails) {
		Student student = studentRepository.findById(id);
	    student.setName(studentDetails.getName());
	    student.setAge(studentDetails.getAge());
	    student.setGrade(studentDetails.getGrade());
	    return studentRepository.save(student);
	}
	
	public void deleteStudentById(int id) {
        Student student = studentRepository.findById(id);
        studentRepository.deleteById(id);
    }
	
	

}
