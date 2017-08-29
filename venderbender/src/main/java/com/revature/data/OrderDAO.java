package com.revature.data;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;

public interface OrderDAO {

	
	//Create
	void createOrder(Order order) throws InvalidDataAccessApiUsageException, UnexpectedTypeException;
	void createOrderItem(OrderItem orderItem);
	//Select
	List<OrderItem> getOrderItems(Order order);
	List<Order>getOrders(Customer customer);
	//Update
	void updateOrderItem(OrderItem item);
	//Delete
	void deleteOrder(Order order);
	void deleteOrderItem(OrderItem item);
}
