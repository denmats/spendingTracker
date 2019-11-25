package com.denmats.tracker.model;


import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	private UUID id;
	private String operation;
	private double amount;
	private String type;
	private String date_tx;
	@Transient
	private double TotalExpense;
	@Transient
	private double TotalIncome;
	
	
	public double getTotalExpense() {
		return TotalExpense;
	}
	
	public double getTotalIncome() {
		return TotalIncome;
	}
	
	
	public Transactions() {}

	public UUID getId() {
		return id;
	}

	public String getOperation() {
		return operation;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public String getDate_tx() {
		return date_tx;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDate_tx(String date_tx) {
		this.date_tx = date_tx;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", operation=" + operation + ", amount=" + amount + ", type=" + type
				+ ", date_tx=" + date_tx + "]";
	}

}
