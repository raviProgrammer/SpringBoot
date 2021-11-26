package com.ravi;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ravi.beans.WishMessage;

@SpringBootApplication
public class SpringBootFirstProjectApplication {
	@Bean("date")
	public Date createdT() {
		return new Date();
	}
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootFirstProjectApplication.class, args);
		WishMessage w=ctx.getBean("wmg",WishMessage.class);
		String status=w.message("Ravi");
		System.out.println(status);
		((ConfigurableApplicationContext) ctx).close();
	}

}
