package com.ravi.service;


import java.util.List;

import com.ravi.Entity.Movie;

public interface IMovieService {
	public String registorMovie(Movie movie);
	public long fetchMovieCount();
	public boolean checkMovieByID(Integer id);
	public Iterable<Movie> fetchAllDataShow();
	public Movie fetchMovieOption(Integer mid);
	public Movie fetchMovieOptionBYId(Integer mid);
	public String GroupMovieRegistor(List<Movie> list);
	
}
