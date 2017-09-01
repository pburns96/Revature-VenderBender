package com.revature.services;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Customer;

@Service
public class AuthenticationService {

	@Autowired
	DataService dataService;

	private boolean loggedIn = false;
	
	private static final Logger log = Logger.getLogger(AuthenticationService.class);
	
	
	public Customer authenticate(Customer customer, HttpSession session){
		log.info("Getting customer by username: " + customer.getUsername() + " in the AuthenticateService");
		Customer validCustomer = dataService.getCustomer(customer.getUsername());
		if(validCustomer != null)
			if(BCrypt.checkpw(customer.getPassword(), validCustomer.getPassword())){
				log.info("Valid customer login");
				session.setAttribute("customer", validCustomer);
				loggedIn = true;
				return validCustomer;
			}
			else{
				log.info("Invalid: WRONG PASSWORD");
				loggedIn = false;
				return null;
			}
		else {
			log.info("False username");
			loggedIn = false;
			return null;
		}
	}
	
	public void logOut(HttpSession session){
		session.invalidate();
		loggedIn = false;
	}
	
	public boolean isLoggedIn(){
		return loggedIn;
	}
	
	public void setDataService(DataService dataService){
		this.dataService = dataService;
	}
}
