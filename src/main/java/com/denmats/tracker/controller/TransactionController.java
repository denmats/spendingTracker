package com.denmats.tracker.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.denmats.tracker.model.Transactions;
import com.denmats.tracker.service.TransactionServiceImpl;

@Controller
public class TransactionController {

	@Autowired
	TransactionServiceImpl transactionServiceImpl;

	@PostMapping("insertTransaction")
	public void insertTransaction(Transactions tx) {
		transactionServiceImpl.insertTransaction(tx);
	}

	@DeleteMapping("deleteTransaction/{id}")
	public void deleteTransaction(@RequestParam("id") UUID id) {
		transactionServiceImpl.deleteTransaction(id);
	}

	@RequestMapping("getTx")
	public String getTx(@RequestParam("id") UUID id, Model m) {
		m.addAttribute("result", transactionServiceImpl.findById(id));
		return "index";
	}
	
	
	@RequestMapping("updateTx")
	public Transactions updateTx(@RequestParam("id") UUID id) {
		return transactionServiceImpl.findById(id);
	}

	@RequestMapping("getTransactions")
	public String selectOperation(@RequestParam("action") String action, Transactions tx, Model m) {
		String message = "";
		
		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "LIST":
			m.addAttribute("list", transactionServiceImpl.list());
			break;

		case "SAVE":
			insertTransaction(tx);
			message = "Record successfully saved!";
			m.addAttribute("message", message);
			m.addAttribute("list", transactionServiceImpl.list());
			break;

		case "DELETE":
			deleteTransaction(tx.getId());
			message = "Record successfully deleted!";
			m.addAttribute("message", message);
			m.addAttribute("list", transactionServiceImpl.list());
			break;
			
		case "EDIT":
			Transactions t = updateTx(tx.getId());
			if(t.getType().equalsIgnoreCase("expense")) {
				m.addAttribute("expense", t);
			}else {
				m.addAttribute("income", t);
			}
			return t.getType();

		default:
			m.addAttribute("list", transactionServiceImpl.list());
			break;

		}

		return "transactions";
	}

}
