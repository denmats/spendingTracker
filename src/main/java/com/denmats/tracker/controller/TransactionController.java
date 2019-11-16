package com.denmats.tracker.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.dao.TxDao;
import com.denmats.tracker.dao.TxDaoImpl;
import com.denmats.tracker.model.Transactions;
import com.denmats.tracker.service.TransactionService;
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
		m.addAttribute(transactionServiceImpl.findById(id).getType(), transactionServiceImpl.findById(id));
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
			if(tx.getType().equalsIgnoreCase("expense")){
				m.addAttribute("expense", updateTx(tx.getId()));
			}else {
				m.addAttribute("income", updateTx(tx.getId()));
			}
			
//			message = "Record successfully updated!";
//			m.addAttribute("result", message);
//			m.addAttribute("list", transactionServiceImpl.list());
			break;

		default:
			m.addAttribute("list", transactionServiceImpl.list());
			break;

		}

		return "transactions";
	}

}
