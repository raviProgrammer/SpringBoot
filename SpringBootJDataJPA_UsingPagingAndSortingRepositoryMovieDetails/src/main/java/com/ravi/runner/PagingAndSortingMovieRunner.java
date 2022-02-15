package com.ravi.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ravi.entity.Movie;
import com.ravi.service.MovieMgmtService;
@Component
public class PagingAndSortingMovieRunner implements CommandLineRunner {
	@Autowired
	private MovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		// find all Movie details using findAll() with Sort concept
		try {
			Iterable<Movie> itr=service.displayMovieByOrder(true, "mname");
			itr.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("----------findAll(Pageable pageable)-------");
		try {
		 Page<Movie> page=service.generateReport(1, 4, true, "mname");
		 System.out.println("page number::"+page.getNumber());
		 System.out.println("pages count::"+page.getTotalPages());
		 System.out.println(" is it first page::"+page.isFirst());
		 System.out.println(" is it last page::"+page.isLast());
		 System.out.println("page Size::"+page.getSize());
		 
		 // How many data to present in current Page
		 System.out.println("page Elements(Record Present this page) count::"+page.getNumberOfElements());
		 if(!page.isEmpty()) {
		   
		    List<Movie> list=page.getContent(); // all content display
		    list.forEach(System.out::println);
		 }
		 else
			 System.out.println("no page found");
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
