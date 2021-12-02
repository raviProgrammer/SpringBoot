package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.dao.IEmployeeDAO;
import com.ravi.model.Employee;
@Service("empservice")
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<Employee> fetchEmpDetails(String desg1, String desg2, String desg3) throws Exception {
		// use the DAO
		List<Employee> listemp=dao.insertEmployee(desg1, desg2, desg3);
		return listemp;
	}

}
