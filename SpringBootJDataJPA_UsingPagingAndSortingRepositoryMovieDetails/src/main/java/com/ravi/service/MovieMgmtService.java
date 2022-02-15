package com.ravi.service;

import org.springframework.data.domain.Page;

import com.ravi.entity.Movie;

public interface MovieMgmtService {
	public Iterable<Movie> displayMovieByOrder(Boolean asc,String...props);
	public  Page<Movie>   generateReport(int pageNo,int pageSize,boolean asc,String ...props);
}
