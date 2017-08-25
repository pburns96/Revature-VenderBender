package com.revature.test;



import static org.junit.Assert.*;

import java.util.Date;

import javax.validation.UnexpectedTypeException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.data.CustomerDAO;
import com.revature.data.OrderDAO;

public class OrderDAOTest {

	static ApplicationContext context;
	
	@BeforeClass
	public static void Init()
	{
		context = new ClassPathXmlApplicationContext("bender.xml");
	}

	@Test
	public void createOrderAndItemTest() {
		OrderDAO dao = (OrderDAO) context.getBean("orderDAO");
		Customer customer= (Customer)context.getBean("customer");
		customer.setFirstname("Patrick");
		customer.setLastname("Burns");
		customer.setEmail("pburns96@live.com");
		customer.setManager(false);
		customer.setUsername("Pburns");
		customer.setPassword("thisismypassword");
		CustomerDAO customerDao = (CustomerDAO)context.getBean("customerDAO");
		Customer customerPat = customerDao.getCustomer("Pburns");
		if(customerPat == null)
		{
			customerDao.createCustomer(customer);			
		}
		else
		{
			customer = customerPat;
		}
		
		//positive test
		//Test against a real customer
		Order order = (Order)context.getBean("order");
		order.setTimeOrdered(new Date());
		order.setOwner(customer);
		dao.createOrder(order);
		
		//test bad paramaeters
		Customer badcustomer= (Customer)context.getBean("customer");
		badcustomer.setFirstname("Bobby");
		badcustomer.setLastname("Drop Tables");
		badcustomer.setEmail("yea@email.com");
		badcustomer.setManager(false);
		badcustomer.setUsername("ooyea");
		badcustomer.setPassword("thisismypassword");
		order.setOwner(badcustomer);
		try
		{
			//test with bad user
			dao.createOrder(order);
		}
		catch (InvalidDataAccessApiUsageException e){
			//passed if it didnt find user
		}
		
		try
		{
			//try setting bad date
			order.setOwner(customer);
			order.setTimeOrdered(null);
		}catch(UnexpectedTypeException e)
		{
			//passed if didnt except null
		}
		
		
		
	}

	@Test
	public void getOrderAndItemTest() {
		
		

	}

	@Test
	public void updateOrderItemTest() {

	}

	@Test
	public void deleteOrdersAndItemTest() {

	}

}
