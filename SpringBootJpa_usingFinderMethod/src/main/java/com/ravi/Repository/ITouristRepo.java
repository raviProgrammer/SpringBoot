package com.ravi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.Entity.Turist;

public interface ITouristRepo extends JpaRepository<Turist, Integer> {
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name=?
	public List<Turist> findByNameEquals(String name);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name like 'R%' (starting R value present)
	public Iterable<Turist> findByNameStartingWith(String name);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name like '%n' (Ending n value present)
	public Iterable<Turist> findByNameEndingWith(String name);
		
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name like '%dhe%' (Ignore Upper and Lower case)
	public Iterable<Turist> findByNameEqualsIgnoreCase(String name);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name like '%dhe%' (Any position this sentence present)
	public Iterable<Turist> findByNameContaining(String name);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name like '----' (Present only 4 letter name)
	public Iterable<Turist> findByNameLike(String name);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where id>? and id<?
	public Iterable<Turist> findByIdGreaterThanAndIdIsLessThan(int min, int max);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where id>=? and id<=?
	public Iterable<Turist> findByIdGreaterThanEqualAndIdIsLessThanEqual(int min,int max);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name=? and country=?
	public Iterable<Turist> findByNameEqualsAndCountryEquals(String name, String country);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where name=? or country=?
	public Iterable<Turist> findByNameEqualsOrCountryEquals(String name, String country);
	
	// select id,name,email,country,contact,desg_state,desg_country,desg_city,desg_date from Turist where contact=? or name in (? , ?) and country=?
	public Iterable<Turist> findByContactEqualsOrNameInAndCountryEquals(Long number, List<String> name, String country);

}
