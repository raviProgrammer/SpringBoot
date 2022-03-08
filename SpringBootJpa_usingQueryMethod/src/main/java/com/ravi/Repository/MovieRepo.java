package com.ravi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ravi.Entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	//@Query("from Movie where id>=?1 and id<=?2") -> JPA ordinal style and always start 1 not 0
	@Query("from Movie where id>=:min and id<=:max") // Named ordinal style and more recommended
	public List<Movie> MovieDetailsByIdRange(int min, int max);
	
	@Query("from Movie where id>=:min and id<=:max")
	public List<Movie> MovieDetailsByIdRanges(@Param("min")int start, @Param("max")int end);
	
	//@Query("from Movie where name in(?1, ?2, ?3) order by name asc") //-> JPA ordinal style
	@Query("from Movie where name in(:name1, :name2, :name3) order by name asc") // named ordinal style
	public List<Movie> MovieDetailsByNameAscending(String name1, String name2, String name3);
	
	@Query("from Movie where name in(:name1, :name2, :name3) order by name desc") // named ordinal style
	public List<Movie> MovieDetailsByNameDesending(String name1, String name2, String name3);
	
	@Query("select name,rate,year from Movie where rate>=:rating and year in(:start, :end)")
	public List<Object[]> MovieDetailsPartialData(Float rating, int start, int end);
	
	@Query("from Movie where name=:movieName")
	public Movie fetchMovieDataByMovieName(String movieName);
	
	@Query("select max(rate),min(rate),avg(rate),count(*),avg(year),sum(year) from Movie")
	public Object fetchMovieAggregateData();
	
	@Query("from Movie where rate=(select max(rate) from Movie)")
	public List<Movie> fetchMaxRateMovies();
	
	
	
	

}
