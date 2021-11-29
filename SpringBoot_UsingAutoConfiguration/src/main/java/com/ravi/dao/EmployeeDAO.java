package com.ravi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDao")
public class EmployeeDAO {
	private static final String GET_EMP_COUNT="SELECT COUNT(*)FROM EMPLOYEE6";
	@Autowired
	private DataSource ds;
	//Method with Persistence(DAO logics) Logics
	public int getEmpsCount()throws Exception{
		// get pool JDBC connection
		Connection con=ds.getConnection();
		// create prepared statement object having SQL Query
		PreparedStatement ps=con.prepareStatement(GET_EMP_COUNT);
		// Execute the query
		ResultSet rs=ps.executeQuery();
		//process the result set
		rs.next();
		int count=rs.getInt(1);
		//close all object connections
		rs.close();
		ps.close();
		con.close();
		return count;
	}
}
