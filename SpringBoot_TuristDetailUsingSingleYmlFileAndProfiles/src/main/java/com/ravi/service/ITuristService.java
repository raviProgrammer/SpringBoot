package com.ravi.service;

import java.util.List;

import com.ravi.model.Turist;

public interface ITuristService {
	public List<Turist> fetchTuristInfo(String state1,String state2,String state3)throws Exception;
}
