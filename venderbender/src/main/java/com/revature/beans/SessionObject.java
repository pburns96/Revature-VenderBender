package com.revature.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionObject {

	private boolean valid;
	private Customer customer;
	
	public SessionObject() {
		super();
		valid = true;
	}
	
	public SessionObject(boolean valid, Customer customer) {
		super();
		this.valid = valid;
		this.customer = customer;
	}

	public void inValidate(){
		valid = false;
		customer = null;
	}
	
	public boolean isValid() {
		return valid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.valid = true;
		this.customer = customer;
	}
}
