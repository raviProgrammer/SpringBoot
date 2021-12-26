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
		  movie.setMname("Pupsha");
		  movie.setYear(2021);
		  movie.setRating(8.0f);
		  try {
			  System.out.println(service.registorMovie(movie));
			  } 
		 catch(Exception e) {
			  e.printStackTrace();
		}
		try {
			System.out.println("How many number of Row Table Data: "+service.fetchMovieCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Check Id for Exiting or Not: "+service.checkMovieByID(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Show All data Table: "+service.fetchAllDataShow());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
