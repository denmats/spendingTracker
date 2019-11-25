package com.denmats.tracker.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denmats.tracker.dao.TxDaoImpl;
import com.denmats.tracker.model.Transactions;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TxDaoImpl txDaoImpl;
	
	
	@Override
	public void insertTransaction(Transactions tx) {
		if(tx.getId() == null) {
			UUID id = UUID.randomUUID();
			tx.setId(id);
		}
		txDaoImpl.insertTransaction(tx);
	}

	
	@Override
	public List<Transactions> list() {
		return txDaoImpl.list();
	}


	@Override
	public void deleteTransaction(UUID id) {
		txDaoImpl.deleteTransaction(id);	
	}

	
	@Override
	public Transactions findById(UUID id) {
		return txDaoImpl.getTx(id);
	}

	
	@Override
	public Transactions updateTx(UUID id) {
		return txDaoImpl.updateTx(id);
	}


	@Override
	public Double getTotalIncome() {
		return txDaoImpl.getTotalIncome();
	}


	@Override
	public Double getTotalExpense() {
		return txDaoImpl.getTotalExpense();
	}
}
