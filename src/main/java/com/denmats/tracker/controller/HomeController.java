package com.denmats.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.dao.TxDaoImpl;
import com.denmats.tracker.model.Transactions;

@Controller
public class HomeController {
	
	@Autowired
	TxDaoImpl txDaoImpl;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Transactions> listGroupByOperation = txDaoImpl.groupByOperation();
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
