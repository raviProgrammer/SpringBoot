package com.ravi.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.Entity.Movie;
import com.ravi.Repository.IMovieRepository;
@Service("movieservice")
public class MovieService implements IMovieService {
	@Autowired
	private IMovieRepository movieRepo;
	
	// Partial Update of Record
	@Override
	public String UpdateMovieDetails(Integer mid,Integer NewYear, Float NewRating) {
		Optional<Movie> opt=movieRepo.findById(mid);
		if(opt.isPresent()) {
			Movie movie=opt.get();
			movie.setYear(NewYear);
			movie.setRating(NewRating);
			movieRepo.save(movie);
			return mid+" Movie id is updated";
		}
		else
			return "Movie id is not Available";
	}
	
	// For Full Object Update of Record
	@Override
	public String MovieUpdate(Movie movie) {
		Optional<Movie> opt=movieRepo.findById(movie.getMid());
		if(opt.isPresent()) {
			movieRepo.save(movie);
			return movie.getMid()+" Movie Full Record are Updated";
		}
		else
			return movie.getMid()+" Movie is not found";
	} 
	
	
}
