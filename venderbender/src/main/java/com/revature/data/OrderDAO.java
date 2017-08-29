package com.revature.data;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;

public interface OrderDAO {

	
	//Create
	public void createOrder(Order order) throws InvalidDataAccessApiUsageException, UnexpectedTypeException;
	public void createOrderItem(OrderItem orderItem);
	//Select
	public List<OrderItem> getOrderItems(Order order);
	public List<Order>getOrders(Customer customer);
	//Update
	public void updateOrderItem(OrderItem item);
	//Delete
	public void deleteOrder(Order order);
	public void deleteOrderItem(OrderItem item);
}
