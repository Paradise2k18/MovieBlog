package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AgeRating;



public interface AgeRatingRepository extends JpaRepository<AgeRating, Integer> {

}
