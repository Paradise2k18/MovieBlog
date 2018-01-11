package com.example.demo.service;

import java.io.IOException;
import java.util.List;


import com.example.demo.entity.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.FilmResponse;



public interface UserService {
	User save(User user) throws IOException;
	boolean login(LoginRequest loginRequest);
	List<User> findAll();
	User findOne(int id);
	boolean delete(Integer id);


}
