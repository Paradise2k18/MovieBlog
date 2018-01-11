package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actors;

import com.example.demo.repository.ActorsRepository;
import com.example.demo.service.ActorsService;

@Service
public class ActorsServiceImpl implements ActorsService {
	@Autowired
	private ActorsRepository actorsRepository;

	public Actors save(Actors actors) {
		return actorsRepository.save(actors);
		
	}

	public List<Actors> findAll() {
		return actorsRepository.findAll();
	}

	public Actors findOne(int id) {
		return actorsRepository.findOne(id);
	}


	@Override
	public boolean delete(Integer id) {
		actorsRepository.delete(id);
		return true;
	}

}
