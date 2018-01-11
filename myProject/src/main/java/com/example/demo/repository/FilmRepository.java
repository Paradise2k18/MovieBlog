package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>,JpaSpecificationExecutor<Film>{

}
