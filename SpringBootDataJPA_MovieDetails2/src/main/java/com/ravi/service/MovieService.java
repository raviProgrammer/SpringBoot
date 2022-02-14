package com.ravi.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	// insert single data to DB table in used to save() concept 
	@Override
	public String registorMovie(Movie movie) {
		System.out.println("InMemory Proxy class Name: "+movieRepo.getClass());
		System.out.println("All Internal interface class Details:"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		System.out.println("Before Saving Table Data is: "+movie);
		movie=movieRepo.save(movie);
		System.out.println("After Saving Table Data is: "+movie);
		return "Movie data is Registored with Id value is: "+movie.getMid();
	}
	
	// long in used to count() method concept
	@Override
	public long fetchMovieCount() {
		return movieRepo.count();
	}
	
	// boolean in used to exitById() method concept
	@Override
	public boolean checkMovieByID(Integer id) {
		
		return movieRepo.existsById(id);
	}
	
	// Iterator<> in used to finalAll() concept
	@Override
	public Iterable<Movie> fetchAllDataShow() {
		return movieRepo.findAll();
	}
	
	// Optional in used to findById() concept
	@Override
	public Movie fetchMovieOption(Integer mid) {
		Optional<Movie> opt=movieRepo.findById(mid);
		if(opt.isPresent()) 
			return opt.get();
		else
			throw new IllegalArgumentException("Record not found:");
	}
	
	// Optional in used to findById() with else concept
	@Override
	public Movie fetchMovieOptionBYId(Integer mid) {
		return movieRepo.findById(mid).orElse(new Movie());
	}
	
	// Group data insert to DB table in used to saveAll() concept 
	@Override
	public String GroupMovieRegistor(List<Movie> movieList) {
		Iterable<Movie> data=movieRepo.saveAll(movieList);
		List<Integer> listIds=new ArrayList<>();
		if(data!=null && ((List<Movie>)data).size()>0) {
			data.forEach(m->{
				listIds.add(m.getMid());
			});
		};
		return listIds.toString()+"Movies are saved";
	}
	
}
