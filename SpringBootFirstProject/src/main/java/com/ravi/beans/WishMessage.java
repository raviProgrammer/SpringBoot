package com.ravi.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessage {
	@Autowired
	private Date date;
	public WishMessage() {
		System.out.println("WishMessage Zero param construtor:");
	}
	public String message(String user) {
		int h=date.getHours();
		if(h<12)
			return "Good Moring:"+user;
		else if(h<16)
				return "Good AfterNoon:"+user;
		else if(h<20)
				return "Good Evening:"+user;
		else
			return "Good Night:"+user;
	}

}
