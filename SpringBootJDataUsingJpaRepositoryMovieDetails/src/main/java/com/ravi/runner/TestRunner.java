package com.ravi.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.service.MovieMgmtService;
@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	private MovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println(service.removeMoviesByIds(List.of(117,120,122)));  // List.of() method not allow to null value
			
			/*List<Integer> list=Arrays.asList(410,null);
			System.out.println(service.removeMoviesByIds(list)); */
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
