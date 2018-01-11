package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String genreName;
	
	@OneToMany(mappedBy = "genre")
	private List<Film> films = new ArrayList<Film>();
	
	

	public Genre() {}
	

	public Genre(String genreName) {
		this.genreName = genreName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}


	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + "]";
	}
	
	

}
