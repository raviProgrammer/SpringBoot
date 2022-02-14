package com.ravi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ravi.Entity.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Integer> {

}
