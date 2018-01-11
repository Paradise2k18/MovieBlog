package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Film;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.SearchingRequest;
import com.example.demo.response.FilmResponse;

import javassist.tools.framedump;

public interface FilmService {
	Film save(Film film);
	Page<FilmResponse> findAll(MyPageRequest page);
	Film findOne(int id);
	boolean delete(Integer id);
	List<Film> findAll(SearchingRequest searchingRequest);
	List<Film> findAll();

}
