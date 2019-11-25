package com.denmats.tracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.denmats.tracker.model.HomeTable;



@Repository
public interface HomeTableDAO extends JpaRepository<HomeTable, String>{
	
	  @Query(
			  value="select * from home_table",
			  nativeQuery=true)
	  List<HomeTable> findAllByOperation();	
}
