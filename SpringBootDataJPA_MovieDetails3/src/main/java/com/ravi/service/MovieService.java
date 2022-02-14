package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.Entity.Movie;
import com.ravi.Repository.IMovieRepository;
@Service("movieservice")
public class MovieService implements IMovieService {
	@Autowired
	private IMovieRepository movieRepo; 
	
	// long in used to count() method concept
	@Override
	public long fetchMovieCount() {
		return movieRepo.count();
	}
	
	// Iterator<> in used to finalAll() concept
	@Override
	public Iterable<Movie> fetchAllDataShow() {
		return movieRepo.findAll();
	}
	// Iterable in used to select multiple ids
	@Override
	public Iterable<Movie> fetchAllMoviesBYIds(List<Integer> ids) {
		return movieRepo.findAllById(ids);
	}
	// select find by id concept
	@Override
	public Movie fetchMovieById(Integer id) {
		Optional<Movie> otp=movieRepo.findById(id);
		if(otp.isPresent())
			return otp.get();
		else
			throw new IllegalArgumentException("Record are not found");
	}
	// used to concept findById with orElseThrow
	@Override
	public Movie fetchMovieUseOrElseThrowById(Integer id) {
		return movieRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Record are not found:"));
	}
	
	
}
