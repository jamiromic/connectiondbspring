package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity vuol dire che l'entità è presente nel database
@Entity
//Viene indicata la tabella di riferimento
@Table(name = "students")
public class Student {
	
	//Indichiamo la chiave primaria
	@Id
	//Diciamo di generare la chiave primaria in autoincrement e unique
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	//Variabili d'istanza
	
	@Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
    
    @Column(name = "grade")
    private String grade;
    
    //Constructor
    
    public Student() {
    	
    }
    
    public Student(int id, String name, int age, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	//Setter e Getter
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   

}