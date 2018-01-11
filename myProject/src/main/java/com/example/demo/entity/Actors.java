package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Actors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String secondName;
	
	private int age;
	
	@ManyToMany
	@JoinTable(name="actors_film", joinColumns= @JoinColumn(name= "id_actors"),inverseJoinColumns = @JoinColumn(name = "id_films") )
	private List<Film> film = new ArrayList<Film>();

	public Actors() {}

	

	public Actors(String firstName, String secondName, int age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public List<Film> getFilm() {
		return film;
	}



	public void setFilm(List<Film> film) {
		this.film = film;
	}



	@Override
	public String toString() {
		return "Actors [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", age=" + age + "]";
	}





	





}
