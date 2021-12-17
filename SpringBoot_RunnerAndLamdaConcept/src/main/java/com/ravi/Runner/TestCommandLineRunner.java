package com.ravi.Runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("clr")
public class TestCommandLineRunner implements CommandLineRunner  {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner "+Arrays.toString(args));
		
	}
	
}
