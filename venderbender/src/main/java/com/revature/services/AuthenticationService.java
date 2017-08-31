package com.revature.services;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Customer;

@Service
public class AuthenticationService {

	@Autowired
	DataService dataService;

	
	private static final Logger log = Logger.getLogger(AuthenticationService.class);
	
	
	public Customer authenticate(Customer customer){
		log.info("Getting customer by username: " + customer.getUsername() + " in the AuthenticateService");
		Customer validCustomer = dataService.getCustomer(customer.getUsername());
		if(validCustomer != null)
			if(BCrypt.checkpw(customer.getPassword(), validCustomer.getPassword())){
				log.info("Valid customer login");
				return validCustomer;
			}
			else{
				log.info("Invalid: WRONG PASSWORD");
				return null;
			}
		else {
			log.info("False username");
			return null;
		}
	}
	
	public void setDataService(DataService dataService){
		this.dataService = dataService;
	}
}
