package com.ravi.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.Entity.Movie;
import com.ravi.Repository.MovieRepo;
@Component
public class QueryMethodTestRunner implements CommandLineRunner {
	@Autowired
	private MovieRepo movierepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		movierepo.MovieDetailsByIdRange(3, 7).forEach(System.out::println);
		movierepo.MovieDetailsByIdRanges(2, 9).forEach(System.out::println);
		movierepo.MovieDetailsByNameAscending("rrr", "batman", "puspha").forEach(System.out::println);
		movierepo.MovieDetailsByNameDesending("rrr", "batman", "puspha").forEach(System.out::println);
		movierepo.MovieDetailsPartialData(6.0f, 2018, 2022).forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
		
		Movie movie=movierepo.fetchMovieDataByMovieName("ironman");
		if(movie!=null)
			System.out.println(movie);
		else
			System.out.println("Movie is not found");
		
		Object []result=(Object[]) movierepo.fetchMovieAggregateData();
		System.out.println("Max rate of data:"+result[0]);
		System.out.println("Min rate of data:"+result[1]);
		System.out.println("Average rate of data:"+result[2]);
		System.out.println("Count of Movie data:"+result[3]);
		System.out.println("Average Year of data:"+result[4]);
		System.out.println("Total sum of Year data:"+result[5]);
		
		movierepo.fetchMaxRateMovies().forEach(System.out::println);
	}
}
