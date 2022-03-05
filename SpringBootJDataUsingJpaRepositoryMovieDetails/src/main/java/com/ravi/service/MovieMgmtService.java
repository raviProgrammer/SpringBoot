package com.ravi.service;

import java.util.List;

import com.ravi.entity.Movie;

public interface MovieMgmtService {
	public String removeMoviesByIds(List<Integer> ids);
	public String deleteMovieById(Integer id);
	
}
