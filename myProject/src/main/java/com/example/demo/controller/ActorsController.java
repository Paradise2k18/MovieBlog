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

import com.example.demo.entity.Actors;
import com.example.demo.request.DeleteObjectByIdRequest;
import com.example.demo.service.ActorsService;

@RestController
@RequestMapping("/actors")
@CrossOrigin
public class ActorsController {
	
	@Autowired
	private ActorsService actorsService;
	
	@GetMapping
	public List<Actors> actors(){
		return actorsService.findAll();
	}

	@PutMapping
	public Actors save(@RequestBody Actors actors) {
		return actorsService.save(actors);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping 
	public boolean delete (@RequestBody DeleteObjectByIdRequest deleteActorRequest) {
		return actorsService.delete(deleteActorRequest.getId());
	}
}
