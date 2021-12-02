package com.ravi.service;

import java.util.List;

import com.ravi.model.Employee;

public interface IEmployeeService {
	public List<Employee> fetchEmpDetails(String desg1, String desg2, String desg3)throws Exception;
}
