package com.denmats.tracker.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.model.Transactions;

public  class TxDaoImpl {
	
	@Autowired
	TxDao txDao;
	
	public List<Transactions> list(){
		List<Transactions> list = txDao.findAll();
		return list;
	}
	
	public List<Transactions> groupByOperation(){
		List<Transactions> listGroupByOperation = txDao.findAllGroupByOperation();
		return listGroupByOperation;
	}
	
	public void saveTransaction(Transactions transaction) {
		txDao.save(transaction);
	}
	
	public void deleteTransaction(@RequestParam UUID id) {
		txDao.deleteById(id);
	}

}
