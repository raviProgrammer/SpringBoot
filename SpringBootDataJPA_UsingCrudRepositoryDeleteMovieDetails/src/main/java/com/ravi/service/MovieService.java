package com.ravi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.Entity.Movie;
import com.ravi.Repository.IMovieRepository;
@Service("movieservice")
public class MovieService implements IMovieService {
	@Autowired
	private IMovieRepository movieRepo;
	
	// Delete record using deleteById() method
	@Override
	public String MovieDeleteById(Integer id) {
		Optional<Movie> opt=movieRepo.findById(id);
		if(opt.isPresent()) {
			movieRepo.deleteById(id);
			return id+" Movie record is deleted";
		}
		else
			return id+" movie record not found";
	}
	
	// Delete all records using by deleteAll() method
	@Override
	public String MovieAllDelete() {
		Long count=movieRepo.count();
		if(count!=0) {
			movieRepo.deleteAll();
			return count+" records are deleted";
		}
		else
			return "recound not found";
	}
	
	// Delete multiple records using by deleteById() method
	@Override
	public String MovieDeleteBYIdMultiple(List<Integer> ids) {
		Iterable<Movie> itr=movieRepo.findAllById(ids);
		long count=((List<Movie>)itr).size();
		if(ids.size()!=0 && ids.size()==count) {
			movieRepo.deleteAllById(ids);
			return count+" record are deleted";
		}
		else
			return "No id's are given to delete or either All same id's are not available to delete";
	}
	
	
	
	
}
