package com.ravi.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="MOVIEDETAILS")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
	@Id
	private Integer id;
	@Column(name="MOVIE_NAME")
	private String name;
	@Column(name="RATING")
	private Float rate;
	private Integer year;
	
}
