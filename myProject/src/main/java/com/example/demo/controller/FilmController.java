package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Film;
import com.example.demo.request.DeleteObjectByIdRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.SearchingRequest;
import com.example.demo.response.FilmResponse;
import com.example.demo.service.FilmService;

@RestController
@RequestMapping("/film")
@CrossOrigin
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@PostMapping
	public Page<FilmResponse> films(@RequestBody MyPageRequest myPageRequest){
		return filmService.findAll(myPageRequest);
	}

	@PutMapping
	public Film save(@RequestBody Film film) {
		return filmService.save(film);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping
	public boolean delete(@RequestBody DeleteObjectByIdRequest deleteFilmRequest) {
		return filmService.delete(deleteFilmRequest.getId());
		
	}
	
	@PostMapping("/search")
	public List<Film> films(@RequestBody SearchingRequest searchingRequest){
		return filmService.findAll(searchingRequest);
	}
	
	@GetMapping
	public List<Film> films(){
		return filmService.findAll();
	}

}
