package com.ravi;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRunnerAndLamdaConceptApplication {
	@Bean
	public CommandLineRunner createCLR() {
		// use Lambda implements for Functional Interface
		/*CommandLineRunner clr=(String...args)->{
			System.out.println("Bean CommandLineRunner: "+Arrays.toString(args));
		};
		return clr; */
		
		// use Lambda implements for Functional Interface
		/* CommandLineRunner clr=args->{System.out.println("Bean CommandLineRunner: "+Arrays.toString(args));};
		return clr; */
		
		// Lambda Implemet for Function Interface with for Each/Enhance for Loop
		/*CommandLineRunner clr=args->{
			System.out.println("Bean CommandLineRunner:");
			for(String arg:args) {
				System.out.println(arg);
				}
			};
		return clr; */
		
		// Lambda for Functional interface and Stream API and Static method reference
		CommandLineRunner clr=args->{
			System.out.println("Bean CommandLineRunner:");
			Stream.of(args).forEach(System.out::println);
			};
		return clr;
	}
	
	@Bean
	public ApplicationRunner createAR() {
		return aargs->{
			System.out.println("Bean ApplicationRunner:");
			System.out.println("non option args values "+aargs.getNonOptionArgs());
			System.out.println("option args names and values:");
			Set<String> opt=aargs.getOptionNames();
			opt.forEach(name->{
				System.out.println(name);
				System.out.println(aargs.getOptionValues(name));
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunnerAndLamdaConceptApplication.class, args);
	}

}
