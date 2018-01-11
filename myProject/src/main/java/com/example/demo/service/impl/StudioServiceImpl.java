package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Studio;
import com.example.demo.repository.StudioRepository;
import com.example.demo.service.StudioService;
@Service
public class StudioServiceImpl implements StudioService{
	@Autowired
	private StudioRepository studioRepository;
	
	@Override
	public Studio save(Studio studio) {
		return studioRepository.save(studio);
	}

	@Override
	public List<Studio> findAll() {
		return studioRepository.findAll();
	}

	@Override
	public Studio findOne(int id) {
		return studioRepository.findOne(id);
	}

	@Override
	public boolean delete(Integer id) {
		studioRepository.delete(id);
		return true;
	}

	

}
