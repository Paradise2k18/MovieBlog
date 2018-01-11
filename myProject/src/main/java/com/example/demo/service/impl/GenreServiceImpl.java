package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import com.example.demo.service.GenreService;
@Service
public class GenreServiceImpl implements GenreService{
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
		
	}

	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findOne(int id) {
		return genreRepository.findOne(id);
	}

	@Override
	public boolean delete(Integer id) {
		genreRepository.delete(id);
		return true;
	}

	

}
