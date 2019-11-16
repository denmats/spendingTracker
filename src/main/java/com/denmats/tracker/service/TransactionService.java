package com.denmats.tracker.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.dao.TxDao;
import com.denmats.tracker.dao.TxDaoImpl;
import com.denmats.tracker.model.Transactions;

public interface TransactionService {
	
	public void insertTransaction(Transactions tx);
	
	public List<Transactions> list();
	
	public List<Transactions> groupByOperation();
	
	public void deleteTransaction(@RequestParam UUID id);
	
	public Transactions findById(UUID id);
	
	public Transactions  updateTx(@RequestParam UUID id);
}
