package com.revature.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class OrderDAOTest {

	ApplicationContext context;
	
	@Test
	public void createOrderAndItemTest()
	{
		OrderDAO dao = context.getBean("OrderDAO");
	}
	
	@Test
	public void getOrderAndItemTest()
	{
		
	}
	@Test
	public void updateOrderItemTest()
	{
		
	}
	@Test
	public void deleteOrdersAndItemTest()
	{
		
	}
	
}
