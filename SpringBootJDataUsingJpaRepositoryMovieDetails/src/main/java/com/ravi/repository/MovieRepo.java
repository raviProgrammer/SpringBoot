package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
