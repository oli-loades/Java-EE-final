package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 1, max =50)
	@NotNull
	private String firstName;
	
	
	@Size(min = 1, max =50)
	@NotNull
	private String surname;
	
	@OneToMany(mappedBy = "trainee_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subject> subjects;
	
	
	public Trainee() {
		
	}
	
	public Trainee(String firstname, String surname) {
		this.firstName = firstname;
		this.surname= surname;
		subjects = new ArrayList<>();
	}
}
