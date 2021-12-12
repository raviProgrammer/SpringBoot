package com.ravi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ravi.model.Turist;
@Repository("oracleTuristDAO")
@Profile({"dev","test"})
public class TuristMysqlDAO implements ITuristDAO{
	private static final String TURIST="SELECT DESG_STATE,DESG_COUNTRY,DESG_CITY,NAME,EMAIL,COUNTRY,CONTACT,DESG_DATE FROM TURIST WHERE DESG_STATE IN(?,?,?)ORDER BY DESG_STATE";
	// HAS-A properties
	@Autowired
	private DataSource ds;
	@Override
	public List<Turist> insertTuristData(String state1, String state2, String state3) throws Exception {
		System.out.println("MysqlDAO class is: "+ds.getClass());
		List<Turist> list=null;
		// Pooled connection logics
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(TURIST)){
			// set Query
			ps.setString(1,state1);
			ps.setString(2, state2);
			ps.setString(3,state3);
			try(ResultSet rs=ps.executeQuery()){
				// List collection of Tourist Information data.
				list=new ArrayList<>();
				while(rs.next()) {
					Turist turist=new Turist();
					turist.setState(rs.getString(1));
					turist.setCountry(rs.getString(2));
					turist.setCity(rs.getString(3));
					turist.setName(rs.getString(4));
					turist.setEmail(rs.getString(5));
					turist.setTurist_country(rs.getString(6));
					turist.setContact(rs.getInt(7));
					turist.setDate(rs.getString(8));
					list.add(turist);
				}
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // reThrowing connect
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; // ReThrowing connect
		}
		return list;
	}

}
