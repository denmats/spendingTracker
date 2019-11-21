package com.denmats.tracker.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

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
	
	
	public void insertTransaction(Transactions transaction) {
		txDao.save(transaction);
	}
	
	
	@Transactional
	public void deleteTransaction(@RequestParam UUID id) {
		txDao.deleteById(id);
	}
	

	public Transactions  getTx(@RequestParam UUID id) {
		Transactions tx = txDao.findById(id);
		return tx;
	}
	
	
	public Transactions  updateTx(@RequestParam UUID id) {
		Transactions tx = txDao.findById(id);
		return tx;
	}
}
