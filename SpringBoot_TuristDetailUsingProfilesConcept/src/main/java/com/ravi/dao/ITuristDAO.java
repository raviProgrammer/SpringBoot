package com.ravi.dao;

import java.util.List;

import com.ravi.model.Turist;

public interface ITuristDAO {
	public List<Turist> insertTuristData(String state1,String state2,String state3)throws Exception;
}
