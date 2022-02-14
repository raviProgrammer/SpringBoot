package com.ravi.service;

import com.ravi.Entity.Movie;

public interface IMovieService {
	public String UpdateMovieDetails(Integer mid,Integer NewYear,Float NewRating);
	public String MovieUpdate(Movie movie);
	
}
