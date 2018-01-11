package com.example.demo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String filmName;
	
	private double filmRating;
	
	private Date premierDate;
	
	private String producer;
	@ManyToOne
	private Country country;
	@ManyToOne
	private Genre genre;
	@ManyToOne
	private AgeRating ageRating;
	@ManyToOne
	private Studio studio;
	@ManyToMany
	@JoinTable(name="actors_film", joinColumns= @JoinColumn(name= "id_films"),inverseJoinColumns = @JoinColumn(name = "id_actors") )
	private List<Actors> actors= new ArrayList<Actors>();
	
	public Film() {}
	

	public Film(String filmName, int filmRating, Date premierDate,String producer) {
		this.filmName = filmName;
		this.filmRating = filmRating;
		this.premierDate = premierDate;
		this.producer = producer;
	}


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public double getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(double filmRating) {
		this.filmRating = filmRating;
	}

	public Date getPremierDate() {
		return premierDate;
	}

	public void setPremierDate(Date premierDate) {
		this.premierDate = premierDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public AgeRating getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(AgeRating ageRating) {
		this.ageRating = ageRating;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", filmName=" + filmName + ", filmRating=" + filmRating + ", premierDate="
				+ premierDate + ", producer=" + producer + "]";
	}
	
	
	
	
	
}
