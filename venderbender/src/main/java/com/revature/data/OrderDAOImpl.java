package com.revature.data;

import java.sql.Date;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.revature.beans.Album;
import com.revature.beans.Concert;
import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;

public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Order createOrder(Customer customer, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem createOrderItem(Order order, Album album, Concert concert, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OrderItem> getOrderItems(Customer customer, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getOrders(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem getOrderItemById(Order order, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderItemQuantity(OrderItem item, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Customer customer, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(Order order, int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
