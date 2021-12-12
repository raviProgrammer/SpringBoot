package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ravi.model.Turist;
import com.ravi.service.ITuristService;
@Controller("control")
public class TuristController {
	@Autowired
	private ITuristService service;
	public List<Turist> showTuristInfo(String state1,String state2,String state3)throws Exception{
		List<Turist> listed=service.fetchTuristInfo(state1, state2, state3);
		return listed;
		}
}
