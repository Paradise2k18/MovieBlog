package com.example.demo.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Film;
import com.example.demo.repository.FilmRepository;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.SearchingRequest;
import com.example.demo.response.FilmResponse;
import com.example.demo.service.FilmService;
import com.example.demo.specification.SearchingFilm;
@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmRepository filmrepository;
	@Override
	public Film save(Film film) {
		return filmrepository.save(film);
		
	}

	

	@Override
	public Film findOne(int id) {
		return filmrepository.findOne(id);
	}

	

	@Override
	public boolean delete(Integer id) {
		filmrepository.delete(id);
		return true;
	}

	@Override
	public Page<FilmResponse> findAll(MyPageRequest page) {
		PageRequest pageRequest = new PageRequest(page.getNumberPage(), page.getSizePage());
		Page<Film> pageFilms = filmrepository.findAll(pageRequest);
		Page<FilmResponse> pageFilmResponse = pageFilms.map(this::convert);
		return pageFilmResponse;
	}
	private FilmResponse convert(Film film) {
		return new FilmResponse(film);
	}



	@Override
	public List<Film> findAll(SearchingRequest searchingRequest) {
		SearchingFilm searchingFilm = new SearchingFilm(searchingRequest);
		return filmrepository.findAll(searchingFilm);
	}



	@Override
	public List<Film> findAll() {
		return filmrepository.findAll();
	}

}
