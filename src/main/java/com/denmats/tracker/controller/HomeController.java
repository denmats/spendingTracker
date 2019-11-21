package com.denmats.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denmats.tracker.dao.HomeTableDAOImpl;
import com.denmats.tracker.model.HomeTable;
import com.denmats.tracker.service.TransactionServiceImpl;

@Controller
public class HomeController {

	@Autowired
	TransactionServiceImpl transactionServiceImpl;

	@Autowired
	HomeTableDAOImpl homeTableDAO;

	@Autowired
	HomeTableDAOImpl homeTableDAOImpl;

	@RequestMapping("/")
	public String home(Model m) {
		List<HomeTable> listGroupBy = homeTableDAOImpl.findAllByOperation();
		m.addAttribute("listTest", listGroupBy);

		return "index";
	}

	@GetMapping("add")
	public String add(@RequestParam("type") String type) {

		switch (type) {
		case "expense":
			break;
		case "income":
			break;
		}
		return type;
	}

	
	/**
	 * displaying pie chart in home page 
	 * pie chart is drawing, when the servlet
	 * redirect to index.jsp at that time, piechart.js is executing
	 */
	@RequestMapping("/piechart")
	public ResponseEntity<?> getPiechartData() {
		List<HomeTable> dataList = homeTableDAOImpl.findAllByOperation();
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
}
