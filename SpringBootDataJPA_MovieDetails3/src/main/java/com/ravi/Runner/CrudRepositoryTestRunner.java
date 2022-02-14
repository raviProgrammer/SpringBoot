package com.ravi.Runner;


import java.util.List;

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
		
		// show all Movie Record with used findAll() method
		  try {
			  Iterable<Movie> it=service.fetchAllDataShow();
			  it.forEach(System.out::println);
		  } 
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		 
		// All Movie data record count using count() method
		  try { 
			  System.out.println("How many number of Row Table Data: "+service.fetchMovieCount()); 
			  } 
		  catch(Exception e) {
			  e.printStackTrace();
			  }
		 
		  // select Id Movie record show using findById() method
		try {
			System.out.println("Single Id base Movie details:"+service.fetchMovieById(18));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// select id movie record show using findById() method with orElseThrow() method
		try {
			System.out.println("Single Id base with orElseThrow concept, Movie details:"+service.fetchMovieUseOrElseThrowById(18));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// select Multiple id movie record show using findAllById() method
		try {
			System.out.println("Multiple id base Movie details:"+service.fetchAllMoviesBYIds(List.of(189,1)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
