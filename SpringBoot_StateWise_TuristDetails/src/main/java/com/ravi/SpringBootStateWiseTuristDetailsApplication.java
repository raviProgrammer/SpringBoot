package com.ravi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ravi.controller.TuristController;
import com.ravi.model.Turist;

@SpringBootApplication
public class SpringBootStateWiseTuristDetailsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootStateWiseTuristDetailsApplication.class, args);
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the First State:");
		String first=s.nextLine();
		System.out.print("Enter the Second State:");
		String second=s.nextLine();
		System.out.print("Enter the Third State:");
		String third=s.nextLine();
		TuristController controller=ctx.getBean("control",TuristController.class);
		try {
			List<Turist> listTurist=controller.showTuristInfo(first, second, third);  
			listTurist.forEach(System.out::println);
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
