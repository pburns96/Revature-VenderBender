package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Order;
import com.revature.services.DataService;

@Controller
public class OrderController {

	@Autowired
	private DataService dataService;

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
	//Get all Orders and provide customer.
	//If you are not a manager than you only retrive orders from that provided customer
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Order>> getAllOrders()
	{
		//Get customer from session
		//return new ResponeEntity<List<Order>>(this.dataService.getOrders())
		return new ResponseEntity<List<Order>>(this.dataService.getOrders(this.dataService.getCustomer("William")),HttpStatus.OK);
	}
	

@RequestMapping(value = "/getOrder", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<Order> getOrdersFromCustomer(@RequestParam int id)
{
//Get customer from session
//TODO PAT: FINISH CONTROLLER and FINISH SERVICE
return null;
//return new ResponseEntity<Order>(this.dataService.getOrder(this.dataService.getCustomer("William"),false),HttpStatus.OK);
}


	
	
}
