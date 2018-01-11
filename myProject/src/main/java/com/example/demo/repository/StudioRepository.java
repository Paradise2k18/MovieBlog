package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

}
