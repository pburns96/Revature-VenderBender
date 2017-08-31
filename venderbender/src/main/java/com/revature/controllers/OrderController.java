package com.revature.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.services.DataService;

@Controller
public class OrderController {

	@Autowired
	private DataService dataService;

	// This is used for creating a Order object for a service side cart for each
	// session
	
	private ApplicationContext applicationContext;
	private static final Logger log = Logger.getLogger(OrderController.class);
	
	

	public OrderController() {
		super();
	}



	@PostConstruct
	public void init() {
		log.trace("OrderController Init");
		applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
	}
	
	

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	// Get all Orders and provide customer.
	// If you are not a manager than you only retrive orders from that provided
	// customer
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Order>> getAllOrders() {
		// Get customer from session
		// If a customer isnt logged in, redirect them to login
		// return new ResponeEntity<List<Order>>(this.dataService.getOrders())
		return new ResponseEntity<List<Order>>(this.dataService.getOrders(this.dataService.getCustomer("wclayton")),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Order> getOrdersFromCustomer(@RequestParam int id) {
		// Get customer from session
		// If a customer isnt logged in the nredirect them to log in
		// If a customer request for a order that isnt theirs throw an error
		return new ResponseEntity<Order>(this.dataService.getOrder(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> createOrder(@RequestBody Order order) {
		// Get customer from session
		// If a customer isnt logged in the nredirect them to log in
		// TODO PAT: replace with session customer
		order.setOwner(this.dataService.getCustomer("William"));
		// If a customer request for a order that isnt theirs throw an error
		this.dataService.createOrder(order);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Order> cartAddItem(@RequestBody OrderItem item, HttpServletRequest request) {
		// If a customer isnt logged in the nredirect them to log in
		if (request.getSession().getAttribute("customer") != null) {
			//applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
			Order cart = (Order) request.getSession().getAttribute("cart");
			if(cart == null)
			{
				cart = (Order)applicationContext.getBean("order");
				request.getSession().setAttribute("cart",cart);
			}
			//If that item is already added then update the quantity instead
			boolean found = false;
			for (OrderItem listItem : cart.getOrderItems()) {
				if(listItem.getId() == item.getId())
				{
					found =true;
					listItem.setQuantity(listItem.getQuantity() + 1);
					break;
				}
			}
			if(!found)
			{
			cart.addOrderItem(item);
			}
			request.getSession().setAttribute("cart",cart);
			return new ResponseEntity<Order>(cart,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Order>(HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/cart/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Order> cartRemoveItem(@RequestBody OrderItem item, HttpServletRequest request) {
		// If a customer isnt logged in the nredirect them to log in
		if (request.getSession().getAttribute("customer") != null) {
			//applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
			Order cart = (Order) request.getSession().getAttribute("cart");
			if(cart == null)
			{
				cart = (Order)applicationContext.getBean("order");
				request.getSession().setAttribute("cart",cart);
			}
			cart.getOrderItems().remove(item);
			request.getSession().setAttribute("cart",cart);
			
			return new ResponseEntity<Order>(cart,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Order>(HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/cart/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Order> cartUpdateItemQuantity(@RequestBody OrderItem item, HttpServletRequest request) {
		// If a customer isnt logged in then redirect them to log in
		if (request.getSession().getAttribute("customer") != null) {
			//applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
			Order cart = (Order) request.getSession().getAttribute("cart");
			if(cart == null)
			{
				cart = (Order)applicationContext.getBean("order");
				request.getSession().setAttribute("cart",cart);
			}
			
			for (OrderItem listItem : cart.getOrderItems()) {
				if(listItem.getId() == item.getId())
				{
					listItem.setQuantity(item.getQuantity());
					break;
				}
			}
			
			request.getSession().setAttribute("cart",cart);
			
			return new ResponseEntity<Order>(cart,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Order>(HttpStatus.FORBIDDEN);
		}
	}
	


}
