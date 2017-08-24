package com.revature.data;

import org.hibernate.SessionFactory;

import com.revature.beans.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	
	
}
