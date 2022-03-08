package com.ravi.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ravi.Repository.MovieRepo;
@Component
public class QueryMethodTestRunner implements CommandLineRunner {
	@Autowired
	private MovieRepo movierepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Updating: "+movierepo.modifyingByMovieName(5.0f, "venom2"));
		System.out.println("deleting: "+movierepo.deleteMovieRecordByyearRange(2014,2018));
		int result=movierepo.registerMovie("dil", 6.7f, 2004);
		System.out.println(result==0?"Movie not registered":"Movie reistered");
		System.out.println("date and time is: "+movierepo.fetchSysDate());
			
		
	}
}
