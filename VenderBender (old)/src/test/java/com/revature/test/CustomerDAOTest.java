package com.revature.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CustomerDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	
	@Test
	public void testGetCustomer1(){
		log.debug("Testing the getCustomer(int id) method");
	}
	
	@Test
	public void testGetCustomer2(){
		log.debug("Testing the getCustomer(String username) method");
	}
	
	@Test
	public void testCreateCustomer(){
		log.debug("Testing the createCustomemr(Customer customer) method");
	}
}
