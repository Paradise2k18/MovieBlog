package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AgeRating;
import com.example.demo.repository.AgeRatingRepository;
import com.example.demo.service.AgeRatingService;
@Service
public class AgeRatingServiceImpl implements AgeRatingService{
	@Autowired
	private AgeRatingRepository ageRatingRepository;
	
	@Override
	public AgeRating save(AgeRating ageRating) {
		return ageRatingRepository.save(ageRating);
	}

	@Override
	public List<AgeRating> findAll() {
		return ageRatingRepository.findAll();
	}

	@Override
	public AgeRating findOne(int id) {
		return ageRatingRepository.findOne(id);
	}

	@Override
	public boolean delete(Integer id) {
		ageRatingRepository.delete(id);
		return true;
	}

	

}
