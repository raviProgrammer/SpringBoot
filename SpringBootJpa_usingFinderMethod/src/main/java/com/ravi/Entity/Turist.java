package com.ravi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Turist {
	@Id
	private Integer id;
	private String name;
	private String email;
	private String country;
	private Long contact;
	private String desg_state;
	private String desg_country;
	private String desg_city;
	private String desg_date;

}
