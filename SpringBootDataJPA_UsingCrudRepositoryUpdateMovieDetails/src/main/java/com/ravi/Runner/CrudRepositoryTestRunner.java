package com.ravi.Runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.Entity.Movie;
import com.ravi.service.IMovieService;

@Component("crudRepoRunner")
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieService service;
	@Override
	public void run(String... args) throws Exception {	
		
		// Partial Update of Record
		System.out.println("Partial update:"+service.UpdateMovieDetails(24, 2022, 3.6f));
		
		// For Full Object Update of Record
		Movie movie=new Movie();
		movie.setMid(5);
		movie.setMname("Spider man");
		movie.setYear(2022);
		movie.setRating(4.5f);
		System.out.println("Full Obect updation:"+service.MovieUpdate(movie));
		
		
		
	}

}
