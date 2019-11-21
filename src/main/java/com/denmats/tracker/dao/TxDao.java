package com.denmats.tracker.dao;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denmats.tracker.model.Transactions;

@Repository
public interface TxDao extends JpaRepository<Transactions, Integer>{
	
	void deleteById(UUID id);

	Transactions findById(UUID id);
}
