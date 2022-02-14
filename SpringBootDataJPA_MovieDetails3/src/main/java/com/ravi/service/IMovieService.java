package com.ravi.service;

import java.util.List;

import com.ravi.Entity.Movie;

public interface IMovieService {
	public long fetchMovieCount();
	public Iterable<Movie> fetchAllDataShow();
	public Movie fetchMovieById(Integer id);
	public Movie fetchMovieUseOrElseThrowById(Integer id);
	public Iterable<Movie> fetchAllMoviesBYIds(List<Integer> ids);
	
}
