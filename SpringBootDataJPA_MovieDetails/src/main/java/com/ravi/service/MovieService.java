package com.ravi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.Entity.Movie;
import com.ravi.Repository.IMovieRepository;
@Service("movieservice")
public class MovieService implements IMovieService {
	@Autowired
	private IMovieRepository movieRepo; 

	@Override
	public String registorMovie(Movie movie) {
		System.out.println("InMemory Proxy class Name: "+movieRepo.getClass());
		System.out.println("All Internal interface class Details:"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		System.out.println("Before Saving Table Data is: "+movie);
		movie=movieRepo.save(movie);
		System.out.println("After Saving Table Data is: "+movie);
		return "Movie data is Registored with Id value is: "+movie.getMid();
	}

}
