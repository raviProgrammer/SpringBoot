package com.ravi.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(21)
public class DCLR implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner in D");

	}

}
