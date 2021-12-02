package com.ravi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ravi.model.Employee;
@Repository("empDAO")
public class EmployeeDAO implements IEmployeeDAO {
	private static final String EMP_DETAILS="SELECT ENAME,JOBTITLE,SALARY,CONTACTNO FROM EMPLOYEEDETAILS WHERE JOBTITLE IN(?,?,?)ORDER BY JOBTITLE";
	@Autowired
	private DataSource ds;
	@Override
	public List<Employee> insertEmployee(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> listemp=null;
		//get pooled connection
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(EMP_DETAILS)){
			// set Query Param values.
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			try(ResultSet rs=ps.executeQuery()){
				// copy the list of collection as Employee details
				listemp=new ArrayList<>();
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEname(rs.getString(1));
					emp.setJob(rs.getString(2));
					emp.setSal(rs.getFloat(3));
					emp.setEno(rs.getInt(4));
					listemp.add(emp);
					
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // reThrowing Exception
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; // reThrowing Exception
		}
		return listemp;
	}

}
