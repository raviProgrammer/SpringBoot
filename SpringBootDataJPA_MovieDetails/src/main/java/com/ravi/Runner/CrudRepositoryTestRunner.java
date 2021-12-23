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
		Movie movie=new Movie();
		movie.setMname("Venom 2");
		movie.setYear(2021);
		movie.setRating(7.0f);
		try {
			System.out.println(service.registorMovie(movie));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
