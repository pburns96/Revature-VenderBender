package com.revature.test;

import java.util.Date;

import javax.validation.UnexpectedTypeException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.util.Assert;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.CustomerDAO;
import com.revature.data.OrderDAO;

public class OrderDAOTest {

	static ApplicationContext context;

	@BeforeClass
	public static void Init() {
		context = new ClassPathXmlApplicationContext("bender.xml");
	}

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
		order.setOwner(badcustomer);
		try {
			// test with bad user
			dao.createOrder(order);
		} catch (InvalidDataAccessApiUsageException e) {
			// passed if it didnt find user
		}

		try {
			// try setting bad date
			order.setOwner(customer);
			order.setTimeOrdered(null);
		} catch (UnexpectedTypeException e) {
			// passed if didnt except null
		}

		// Testing OrderItem creation

		// positive testing
		/*OrderItem item = (OrderItem) context.getBean("orderItem");
		order.setOwner(customer);
		order.setTimeOrdered(new Date());
		dao.createOrder(order);
		item.setOrder(order);
		item.setQuantity('1');
		dao.createOrderItem(item);

		OrderItem item2 = (OrderItem) context.getBean("orderItem");
		try {
			item2.setOrder(null);
			dao.createOrderItem(item2);
		} catch (UnexpectedTypeException e) {
			// passes if throws Exception
		}
		try {
			item2.setOrder(order);
			item2.setQuantity(-1);
			dao.createOrderItem(item2);
		} catch (UnexpectedTypeException e) {
			// passes if throws Exception
		}
*/
		// When deleteing a customer, it deletes all the Orders and orderitems
		customerDao.deleteCustomer(customer);
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
