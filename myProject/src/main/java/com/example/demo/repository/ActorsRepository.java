package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Actors;




public interface ActorsRepository extends JpaRepository<Actors, Integer> {

}
