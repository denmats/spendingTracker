package com.denmats.tracker.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.denmats.tracker.model.Transactions;

public interface TxDao extends JpaRepository<Transactions, Integer>{
	
	@Query(
			value="select * from transactions",
			nativeQuery=true)
	List<Transactions> findAllGroupByOperation();

	
	void deleteById(UUID id);
	
}
