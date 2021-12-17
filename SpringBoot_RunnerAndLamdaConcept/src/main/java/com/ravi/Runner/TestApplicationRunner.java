package com.ravi.Runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component("apr")
public class TestApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("AppicationRunner ");
		System.out.println("non option args values:"+args.getNonOptionArgs());
		System.out.println("option args names and values:");
		for(String name:args.getOptionNames()) {
			System.out.println(name+" : "+args.getOptionValues(name));
		}
	}

}
