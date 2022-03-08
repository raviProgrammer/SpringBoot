package com.ravi.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="MOVIEDETAILS")
@RequiredArgsConstructor
@NoArgsConstructor
@DynamicInsert(true)
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="MOVIE_NAME")
	@NonNull
	private String name;
	@Column(name="RATING")
	@NonNull
	private Float rate;
	@NonNull
	private Integer year;
	
}
