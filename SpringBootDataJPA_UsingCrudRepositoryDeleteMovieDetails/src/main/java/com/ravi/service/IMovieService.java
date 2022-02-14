package com.ravi.service;

import java.util.List;

public interface IMovieService {
	public String MovieDeleteById(Integer id);
	public String MovieAllDelete();
	public String MovieDeleteBYIdMultiple(List<Integer> ids);
	
}
