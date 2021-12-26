package com.ravi.service;

import com.ravi.Entity.Movie;

public interface IMovieService {
	public String registorMovie(Movie movie);
	public long fetchMovieCount();
	public boolean checkMovieByID(Integer id);
	public Iterable<Movie> fetchAllDataShow();
}
