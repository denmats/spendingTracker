package com.denmats.tracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.denmats.tracker.model.HomeTable;

public class HomeTableDAOImpl {
	
	@Autowired
	HomeTableDAO homeTableDAO;
	
	public List<HomeTable> findAllByOperation(){
		List<HomeTable> listGroupByOperation = homeTableDAO.findAll();
		return listGroupByOperation;
	}

}
