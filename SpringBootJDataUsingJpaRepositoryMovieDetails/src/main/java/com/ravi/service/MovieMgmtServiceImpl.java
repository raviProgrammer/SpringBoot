package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Movie;
import com.ravi.repository.MovieRepo;
@Service
public class MovieMgmtServiceImpl implements MovieMgmtService {
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public String removeMoviesByIds(List<Integer> ids) {
		List<Movie> list=movieRepo.findAllById(ids);
		long count=list.size();
		if(count!=0) {
			movieRepo.deleteAllByIdInBatch(ids);
			return count+": Number of records are deleted:";
		}
		else
			return "record id not found";
		
	}

	

}
