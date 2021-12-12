package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.dao.ITuristDAO;
import com.ravi.model.Turist;
@Service("serviceTurist")
public class TuristService implements ITuristService {
	@Autowired
	private ITuristDAO dao;
	@Override
	public List<Turist> fetchTuristInfo(String state1, String state2, String state3) throws Exception {
		// Used the DAO
		List<Turist> lists=dao.insertTuristData(state1, state2, state3);
		return lists;
	}

}
