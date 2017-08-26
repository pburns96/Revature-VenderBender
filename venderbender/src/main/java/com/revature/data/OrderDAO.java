package com.revature.data;

import java.util.Set;

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
	Set<OrderItem> getOrderItems(Order order);
	Set<Order>getOrders(Customer customer);
	OrderItem getOrderItemById(Order order, int id);
	//Update
	void updateOrderItemQuantity(OrderItem item, int quantity);
	//Delete
	void deleteOrder(Customer customer, Order order);
	void deleteOrderItem(Order order, int id);
}
