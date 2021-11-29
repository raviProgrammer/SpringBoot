package com.ravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ravi.dao.EmployeeDAO;

@SpringBootApplication
public class SpringBootUsingAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootUsingAutoConfigurationApplication.class, args);
		EmployeeDAO emp=ctx.getBean("empDao",EmployeeDAO.class);
		// invoke the method
		try {
			System.out.println("Employee data Count is :"+emp.getEmpsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
