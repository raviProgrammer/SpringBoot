package com.ravi.Runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.service.IMovieService;

@Component("crudRepoRunner")
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieService service;
	@Override
	public void run(String... args) throws Exception {	
		
		// Delete record using deleteById() method
		try {
			System.out.println(service.MovieDeleteById(24));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// Delete all records using by deleteAll() method
		try {
			System.out.println(service.MovieAllDelete());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// Delete multiple records using by deleteById() method
		try {
			System.out.println(service.MovieDeleteBYIdMultiple(List.of(118,119)));
		}
		catch(NullPointerException np) {
			System.out.println("Ids must not be null");
			np.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
