package com.denmats.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.model.Transactions;
import com.denmats.tracker.service.TransactionServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@RequestMapping("/")
	public String home(Model m) {
		
		  List<Transactions> listGroupByOperation = transactionServiceImpl.groupByOperation();
		  m.addAttribute("listGroupByOperation", listGroupByOperation);
		 
		return "index";
	}
	

	@GetMapping("add")
	public String add(@RequestParam("type") String type) {
		
		switch(type) {
		case "expense":
			break;
		case "income":
			break;
		}	
		return type;
	}
	
	
}
