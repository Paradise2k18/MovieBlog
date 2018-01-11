package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Actors;


public interface ActorsService {
	Actors save(Actors actors);
	List<Actors> findAll();
	Actors findOne(int id);
	boolean delete(Integer id);

}
