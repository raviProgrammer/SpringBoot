package com.ravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ravi.dao.BookDAO;

@SpringBootApplication
public class SpringBootUsingAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootUsingAutoConfigurationApplication.class, args);
		BookDAO book=ctx.getBean("bookdao",BookDAO.class);
		// invoke the method
		try {
			System.out.println("Book data Count is :"+book.getBooksCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
