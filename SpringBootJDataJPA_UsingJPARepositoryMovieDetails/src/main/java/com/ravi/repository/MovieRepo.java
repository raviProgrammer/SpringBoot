package com.ravi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ravi.entity.Movie;

public interface MovieRepo extends PagingAndSortingRepository<Movie, Integer> {

}
