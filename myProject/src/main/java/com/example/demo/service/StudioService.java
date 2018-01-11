package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Studio;


public interface StudioService {
	Studio save(Studio studio);
	List<Studio> findAll();
	Studio findOne(int id);
	boolean delete(Integer id);

}
