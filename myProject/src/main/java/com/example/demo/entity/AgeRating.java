package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AgeRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ageRatingName;
	
	@OneToMany(mappedBy = "ageRating")
	private List<Film> films = new ArrayList<Film>();
	
	
	public AgeRating() {
	}

	public AgeRating(String ageRatingName) {
		this.ageRatingName = ageRatingName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgeRatingName() {
		return ageRatingName;
	}

	public void setAgeRatingName(String ageRatingName) {
		this.ageRatingName = ageRatingName;
	}
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "AgeRating [id=" + id + ", ageRatingName=" + ageRatingName + "]";
	}

	
}
