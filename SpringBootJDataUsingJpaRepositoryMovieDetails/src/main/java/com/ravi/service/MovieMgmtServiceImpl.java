package com.ravi.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String deleteMovieById(Integer id) {
		Optional<Movie> opt=movieRepo.findById(id);
		if(opt.isPresent()) {
			movieRepo.deleteById(id);
			return id+" is deleted successfully";
		}
		else
			return id+ " is not found";
	}
}
