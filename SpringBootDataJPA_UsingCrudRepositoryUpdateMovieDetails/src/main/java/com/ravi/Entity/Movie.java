package com.ravi.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="MOVIEDETAILS")
public class Movie implements Serializable {
	@Id
	@Column(name="ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mid;
	@Column(name="MOVIE_NAME", length=40)
	@NonNull
	private String mname;
	@Column(name="YEAR")
	@NonNull
	private Integer year;
	@Column(name="RATING")
	@NonNull
	private Float rating;
	
}
