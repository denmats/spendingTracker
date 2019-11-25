package com.denmats.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "home_table")
public class HomeTable {
	@Id
	private String operation;
	private double sum;


	public String getOperation() {
		return operation;
	}
	public double getSum() {
		return sum;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
	@Override
	public String toString() {
		return "HomeTable [operation=" + operation + ", sum=" + sum + "]";
	}
}
