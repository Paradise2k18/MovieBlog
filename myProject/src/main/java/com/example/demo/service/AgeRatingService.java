package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AgeRating;

public interface AgeRatingService {
	AgeRating save(AgeRating ageRating);
	List<AgeRating> findAll();
	AgeRating findOne(int id);
	boolean delete(Integer id);

}
