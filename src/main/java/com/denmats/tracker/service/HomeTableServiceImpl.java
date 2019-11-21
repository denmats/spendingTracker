package com.denmats.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.denmats.tracker.dao.HomeTableDAOImpl;
import com.denmats.tracker.model.HomeTable;

public class HomeTableServiceImpl {
	
	@Autowired
	HomeTableDAOImpl homeTableDAOImpl;
	
	List<HomeTable> findAllByOperation(){
		List<HomeTable> listGroupByOperation = homeTableDAOImpl.findAllByOperation();
		return listGroupByOperation;
	}
}
