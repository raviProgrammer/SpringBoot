package com.ravi.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.Repository.ITouristRepo;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {
	@Autowired
	private ITouristRepo turistRepo;

	@Override
	public void run(String... args) throws Exception {
		
		// FinderMethod
		turistRepo.findByNameEquals("nancy").forEach(System.out::println);
		turistRepo.findByNameStartingWith("l").forEach(System.out::println);
		turistRepo.findByNameEndingWith("n").forEach(System.out::println);
		turistRepo.findByNameEqualsIgnoreCase("NancY").forEach(System.out::println);
		turistRepo.findByNameContaining("na").forEach(System.out::println);
		
		// Starting with na
		turistRepo.findByNameLike("na%").forEach(System.out::println);
		// Present only 4 Letter name output that means 4 Under Line(_) are present then 4 latter name if 3 line then 3 latter name
		turistRepo.findByNameLike("____").forEach(System.out::println);
		// Ending sentence is present na
		turistRepo.findByNameLike("na%").forEach(System.out::println);
		// Ending or Ending both is present na that means containing
		turistRepo.findByNameLike("%na%").forEach(System.out::println);
		
		turistRepo.findByIdGreaterThanAndIdIsLessThan(3, 9).forEach(System.out::println);
		turistRepo.findByIdGreaterThanEqualAndIdIsLessThanEqual(3, 9).forEach(System.out::println);
		turistRepo.findByNameEqualsAndCountryEquals("nancy", "USA").forEach(System.out::println);
		turistRepo.findByNameEqualsOrCountryEquals("nancy", "USA").forEach(System.out::println);
		turistRepo.findByContactEqualsOrNameInAndCountryEquals(900l, List.of("nancy","lisa"), "USA").forEach(System.out::println);

	}

}
