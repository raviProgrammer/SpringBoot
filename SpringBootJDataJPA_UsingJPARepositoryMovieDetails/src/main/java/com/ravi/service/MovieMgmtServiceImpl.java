package com.ravi.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ravi.entity.Movie;
import com.ravi.repository.MovieRepo;
@Service
public class MovieMgmtServiceImpl implements MovieMgmtService {
	@Autowired
	private MovieRepo movieRepo;

	// find all Movie details using findAll() with Sort concept
	@Override
	public Iterable<Movie> displayMovieByOrder(Boolean asc, String...props) {
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		return movieRepo.findAll(sort);
	}
	
	// find all movie details but paging and sorting concept 
	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props) {
		//create Pageable object
	     PageRequest pageable=PageRequest.of(pageNo, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC, props));
	     // get requested page records
	     Page<Movie> page=movieRepo.findAll(pageable);
		return page;
	}

}
