package com.denmats.tracker.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.model.Transactions;


public interface TransactionService {
	
	public void insertTransaction(Transactions tx);
	
	public List<Transactions> list();
	
	public void deleteTransaction(@RequestParam UUID id);
	
	public Transactions findById(UUID id);
	
	public Transactions  updateTx(@RequestParam UUID id);
}
