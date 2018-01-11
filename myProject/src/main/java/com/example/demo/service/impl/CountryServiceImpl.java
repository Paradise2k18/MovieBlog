package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;
	@Override
	public Country save(Country country) {
		return countryRepository.save(country);		
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}



	@Override
	public boolean delete(Integer id) {
		countryRepository.delete(id);
		return true;
	}

}
