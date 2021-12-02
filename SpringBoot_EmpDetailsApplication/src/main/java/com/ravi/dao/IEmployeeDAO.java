package com.ravi.dao;

import java.util.List;

import com.ravi.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> insertEmployee(String desg1,String desg2,String desg3)throws Exception;
}
