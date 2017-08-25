package com.revature.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.revature.data.OrderDAO;

public class OrderDAOTest {

	ApplicationContext context;

	@Test
	public void createOrderAndItemTest() {
		OrderDAO dao = (OrderDAO) context.getBean("OrderDAO");
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
