package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.CustomerDAO;
import com.revature.data.OrderDAO;

public class OrderDAOTest {

	static ApplicationContext context;

	@BeforeClass
	public static void Init() {
		context = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
	}

	@Ignore
	@Test
	public void createOrderandItemTest() {
		OrderDAO dao = (OrderDAO) context.getBean("orderDAO");
		Customer customer = (Customer) context.getBean("customer");
		customer.setFirstname("Patrick");
		customer.setLastname("Burns");
		customer.setEmail("pburns96@live.com");
		customer.setManager(false);
		customer.setUsername("Pburns");
		customer.setPassword("thisismypassword");
		CustomerDAO customerDao = (CustomerDAO) context.getBean("customerDAO");
		Customer customerPat = customerDao.getCustomer("Pburns");
		if (customerPat == null) {
			customerDao.createCustomer(customer);
		} else {
			customer = customerPat;
		}

		// positive test
		// Test against a real customer
		Order order = (Order) context.getBean("order");
		order.setTimeOrdered(new Date());
		order.setOwner(customer);
		dao.createOrder(order);

		// test bad paramaeters
		Customer badcustomer = (Customer) context.getBean("customer");
		badcustomer.setFirstname("Bobby");
		badcustomer.setLastname("Drop Tables");
		badcustomer.setEmail("yea@email.com");
		badcustomer.setManager(false);
		badcustomer.setUsername("ooyea");
		badcustomer.setPassword("thisismypassword");
		Order order2 = (Order) context.getBean("order");
		order2.setOwner(badcustomer);
		try {
			// test with bad user
			dao.createOrder(order2);
		} catch (InvalidDataAccessApiUsageException e) {
			// passed if it didnt find user
		}

		try {
			// try setting bad date
			order2.setOwner(customer);
			order2.setTimeOrdered(null);
		} catch (UnexpectedTypeException e) {
			// passed if didnt except null
		}

		// Testing OrderItem creation
	
		// positive testing
		OrderItem item = (OrderItem) context.getBean("orderItem");
		System.out.println("Adding order Item");
		item.setOrder(order);
		item.setQuantity('1');
		dao.createOrderItem(item);
		//order.addOrderItem(item);

		
		

		OrderItem item2 = (OrderItem) context.getBean("orderItem");
		try {
			item2.setOrder(null);
			dao.createOrderItem(item2);
		} catch (ConstraintViolationException e) {
			// passes if throws Exception
		}
		try {
			item2.setOrder(order);
			item2.setQuantity(-1);
			dao.createOrderItem(item2);
		} catch (ConstraintViolationException e) {
			// passes if throws Exception
		}

		// When deleteing a customer, it deletes all the Orders and orderitems
		customerDao.deleteCustomer(customerDao.getCustomer("Pburns"));
	}

	@Test
	@Ignore
	public void getOrderAndItemTest() {
		OrderDAO dao = (OrderDAO) context.getBean("orderDAO");
		Customer customer = (Customer) context.getBean("customer");
		customer.setFirstname("Patrick");
		customer.setLastname("Burns");
		customer.setEmail("pburns96@live.com");
		customer.setManager(false);
		customer.setUsername("Pburns");
		customer.setPassword("thisismypassword");
		CustomerDAO customerDao = (CustomerDAO) context.getBean("customerDAO");
		Customer customerPat = customerDao.getCustomer("Pburns");
		if (customerPat == null) {
			customerDao.createCustomer(customer);
		} else {
			customer = customerPat;
		}

		// positive test
		// Test against a real customer
		Order order = (Order) context.getBean("order");
		Date date = new Date();
		Calendar calendar = new Calendar.Builder().build();
		calendar.set(2000,11,11);
		order.setTimeOrdered(calendar.getTime());
		order.setOwner(customer);
		dao.createOrder(order);
		
		List<Order> orders = dao.getOrders(customer);
		assertEquals(orders.get(0),order);
		
		OrderItem item = (OrderItem) context.getBean("orderItem");
		item.setOrder(order);
		item.setQuantity(2);
		dao.createOrderItem(item);
		List<OrderItem>items = dao.getOrderItems(order);
		
		assertEquals(items.get(0),item);
		
		
	}

	@Test
	public void updateOrderItemTest() {
		
		
		
	}

	@Test
	public void deleteOrdersAndItemTest() {

	}

}
