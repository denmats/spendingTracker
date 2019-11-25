package com.denmats.tracker.dao;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.denmats.tracker.model.Transactions;

@Repository
public interface TxDao extends JpaRepository<Transactions, Integer>{
	
	void deleteById(UUID id);

	
	Transactions findById(UUID id);

	
	@Query(
			value="select * from transactions order by date_tx desc",
			nativeQuery=true)
	List<Transactions> findAllOrderByDateDesc();
	
	
	@Query(
			value="select sum(amount) from transactions where type='income'",
			nativeQuery=true)
	Double getTotalIncome(); 
	
	
	@Query(
			value="select sum(amount) from transactions where type='expense'",
			nativeQuery=true)
	Double getTotalExpense();
	
}
