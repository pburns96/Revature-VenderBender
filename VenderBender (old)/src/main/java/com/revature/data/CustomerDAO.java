package com.revature.data;

import com.revature.beans.Customer;

public interface CustomerDAO {

	public Customer getCustomer(int id);
	public Customer getCustomer(String username);
	
	public void createCustomer(Customer customer);
}
