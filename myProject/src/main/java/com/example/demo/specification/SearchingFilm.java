package com.example.demo.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.Film;
import com.example.demo.request.SearchingRequest;

public class SearchingFilm implements Specification<Film>{
	private SearchingRequest searchingRequest;
	
	

	public SearchingFilm(SearchingRequest searchingRequest) {
		this.searchingRequest = searchingRequest;
	}



	@Override
	public Predicate toPredicate(Root<Film> rootFilm, CriteriaQuery<?> crq, CriteriaBuilder crb) {
		CriteriaBuilder cb = crb;
		CriteriaQuery<?> cq = crq;
		Root<Film> root = rootFilm;
		Predicate predicate = cb.like(root.get("filmName"),"%"+searchingRequest.getFilmName()+"%" );
		return predicate;
	}

}
