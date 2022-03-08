package com.ravi.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ravi.Entity.Movie;

@Transactional
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query("update Movie set rate=:newRate where name=:newName")
	@Modifying
	public int modifyingByMovieName(float newRate, String newName);
	
	@Query("delete from Movie where year>=:startYear and year<=:endYear")
	@Modifying
	public int deleteMovieRecordByyearRange(int startYear, int endYear);
	
	// use to NativeQuery
	//@Query(value="INSERT INTO MOVIEDETAILS VALUES(Sequence name,?,?,?)",nativeQuery=true) -> used in oracle database query
	@Query(value="INSERT INTO MOVIEDETAILS(MOVIE_NAME,RATING,YEAR) VALUES(?,?,?)",nativeQuery=true) // used in Mysql data query
	@Modifying
	public int registerMovie(String name, float rate, int year);
	
	// if @Modifying is used then create error because @Modifying is not return String type. only return int, shot, long, float.
	//@Query(value="SELECT SYSDATE from DUAL",nativeQuery = true) -> used in oracle databse
	@Query(value="SELECT SYSDATE()",nativeQuery = true) // used in mysql database
	public String fetchSysDate();

}
