package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Genre;

public interface GenreService {
	Genre save(Genre genre);
	List<Genre> findAll();
	Genre findOne(int id);
	boolean delete(Integer id);

}
