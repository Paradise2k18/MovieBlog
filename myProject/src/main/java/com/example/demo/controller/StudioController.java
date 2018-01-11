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

import com.example.demo.entity.Studio;
import com.example.demo.request.DeleteObjectByIdRequest;
import com.example.demo.service.StudioService;

@RestController
@RequestMapping("/studio")
@CrossOrigin
public class StudioController {

	@Autowired
	private StudioService studioService;
	
	@GetMapping
	public List<Studio> studios(){
		return studioService.findAll();
	}
	
	@PutMapping
	public Studio save(@RequestBody Studio studio) {
		return studioService.save(studio);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping
	public boolean delete(@RequestBody DeleteObjectByIdRequest deleteStudioRequest) {
		return studioService.delete(deleteStudioRequest.getId());
	}
}
