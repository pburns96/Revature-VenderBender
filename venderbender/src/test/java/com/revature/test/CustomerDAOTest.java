package com.revature.test;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Customer;
import com.revature.data.CustomerDAO;

public class CustomerDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	
	private CustomerDAO customerDao;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("bender.xml");
	}
	
	@Test
	public void testGetCustomer1(){
		log.debug("Testing the getCustomer(int id) method");
		customerDao = (CustomerDAO)context.getBean("customerDAO");
		log.debug(customerDao.getCustomer(2));
	}
	
	@Test
	public void testGetCustomer2(){
		log.debug("Testing the getCustomer(String username) method");
		customerDao = (CustomerDAO)context.getBean("customerDAO");
		log.debug(customerDao.getCustomer("wclayton"));
	}
	
	@Test
	public void testCreateCustomer(){
		log.debug("Testing the createCustomemr(Customer customer) method");
		customerDao = (CustomerDAO)context.getBean("customerDAO");
		Customer customer = (Customer)context.getBean("customer");
		customer.setUsername("wclayton");
		customer.setPassword("password");
		customer.setFirstname("William");
		customer.setLastname("Clayton");
		customer.setEmail("will@email.com");
		customer.setManager(true);
		//customerDao.createCustomer(customer);
	}
}
