package com.ravi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ravi.controller.EmployeeController;
import com.ravi.model.Employee;

@SpringBootApplication
public class SpringBootEmpDetailsApplication {

	public static void main(String[] args) {
		// Get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringBootEmpDetailsApplication.class, args);
		//Get Controller class Object
		EmployeeController controle=ctx.getBean("controller",EmployeeController.class);
		// get input from End user
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the First Designation:");
		String first=s.nextLine();
		System.out.print("Enter the Second Designation:");
		String second=s.nextLine();
		System.out.print("Enter the Third Designation:");
		String third=s.nextLine();
		// invoke the method
		try {
			List<Employee> listemp=controle.showEmpDetails(first, second, third);
					
			/*
			 * for(Employee e:listemp) { // Enhanced for loop System.out.println(e); }
			 */
			  
			  listemp.forEach(System.out::println);
			 }
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Internal DataBase Problem:");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Unknown Problem:");
		}
		s.close();
		((ConfigurableApplicationContext) ctx).close();
	}

}
