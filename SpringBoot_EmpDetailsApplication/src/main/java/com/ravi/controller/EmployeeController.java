package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ravi.model.Employee;
import com.ravi.service.IEmployeeService;

@Controller("controller")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	public List<Employee> showEmpDetails(String desg1,String desg2,String desg3)throws Exception{
		// used the service
		List<Employee> listemp=service.fetchEmpDetails(desg1,desg2,desg3);
		return listemp;
	}
}
