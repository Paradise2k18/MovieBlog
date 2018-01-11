package com.example.demo.response;

import com.example.demo.entity.Film;

public class FilmResponse {

	private String filmName;
	private double filmRating;
	private String producer;
	
	public FilmResponse(Film film) {
		this.filmName = film.getFilmName();
		this.filmRating = film.getFilmRating();
		this.producer = film.getProducer();
		
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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "FilmResponse [filmName=" + filmName + ", filmRating=" + filmRating + ", producer=" + producer + "]";
	}

	

}
