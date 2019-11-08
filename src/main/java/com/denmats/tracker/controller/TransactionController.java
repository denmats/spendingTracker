package com.denmats.tracker.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.dao.TxDao;
import com.denmats.tracker.dao.TxDaoImpl;
import com.denmats.tracker.model.Transactions;

@Controller
public class TransactionController {
	
	@Autowired
	TxDaoImpl txDaoImpl;
	
	
	@PostMapping("save")
	public void save(Transactions tx) {
		tx.setId(UUID.randomUUID());
		txDaoImpl.saveTransaction(tx);
	}
	
	@PostMapping("getTransactions")
	public String selectOperation(@RequestParam("action") String action, Transactions tx, Model m) {
		
		if(action == null) {
			action="LIST";
		}
		
		switch(action) {
		case "LIST":
			m.addAttribute("list", txDaoImpl.list());
			break;
			
		case "SAVE":
			save(tx);
			m.addAttribute("list", txDaoImpl.list());
			break;
			
		default:
			m.addAttribute("list", txDaoImpl.list());
			break;
				
		}
		
		return "transactions";
	}
	
	
	
	
	
}
