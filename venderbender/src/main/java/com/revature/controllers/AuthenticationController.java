package com.revature.controllers;

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
import com.revature.beans.SessionObject;
import com.revature.services.AuthenticationService;
import com.revature.services.DataService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private AuthenticationService authenticationService;
	
	//@Autowired
	public SessionObject sessionObject;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> authenticate(@RequestBody Customer customer){
		//SessionObject session = getSessionObject();
		Customer validCustomer = authenticationService.authenticate(customer);
		if(validCustomer != null){
			sessionObject.setCustomer(validCustomer);
			return new ResponseEntity<Customer>(validCustomer,HttpStatus.OK);
		}
		else{
			sessionObject.inValidate();
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
	}
}	
