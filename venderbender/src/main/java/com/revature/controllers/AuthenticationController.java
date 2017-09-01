package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Customer;
import com.revature.services.AuthenticationService;

@Controller
public class AuthenticationController {
	
	private static final Logger log = Logger.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> authenticate(@RequestBody Customer customer, HttpServletRequest request){
		log.debug("Logging in");
		Customer validCustomer = authenticationService.authenticate(customer,request.getSession());
		if(validCustomer != null){
			return new ResponseEntity<Customer>(validCustomer,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Void> logout(HttpServletRequest request){
		log.debug("Logging out");
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}	
