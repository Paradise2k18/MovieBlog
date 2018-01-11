package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Genre;

import com.example.demo.request.DeleteObjectByIdRequest;
import com.example.demo.service.GenreService;

@RestController
@RequestMapping("/genre")
@CrossOrigin
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public List<Genre> genres(){
		return genreService.findAll();
	}
	
	@PutMapping
	public Genre save(@RequestBody Genre genre) {
		return genreService.save(genre);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping
	public boolean delete(@RequestBody DeleteObjectByIdRequest deleteGenreRequest) {
		return genreService.delete(deleteGenreRequest.getId());
	}
}
	
