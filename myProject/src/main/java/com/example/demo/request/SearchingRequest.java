package com.example.demo.request;

public class SearchingRequest {
	private String filmName;

	public SearchingRequest() {}

	public SearchingRequest(String filmName) {
		super();
		this.filmName = filmName;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	@Override
	public String toString() {
		return "SearchingRequest [filmName=" + filmName + "]";
	}
	

}
