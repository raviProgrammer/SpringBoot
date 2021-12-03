package com.ravi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turist {
	private String state;
	private String country;
	private String city;
	private String name;
	private String email;
	private String turist_country;
	private Integer contact;
	private String date;
}
