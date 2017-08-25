package com.revature.data;

import java.sql.Date;
import java.util.Set;

import com.revature.beans.Album;
import com.revature.beans.Concert;
import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;

public interface OrderDAO {

	
	//Create
	Order createOrder(Customer customer, Date date);
	OrderItem createOrderItem(Order order,Album album, Concert concert, int quantity);
	//Select
	Set<OrderItem> getOrderItems(Customer customer,Order order);
	Set<Order>getOrders(Customer customer);
	OrderItem getOrderItemById(Order order, int id);
	//Update
	void updateOrderItemQuantity(OrderItem item, int quantity);
	//Delete
	void deleteOrder(Customer customer, Order order);
	void deleteOrderItem(Order order, int id);
}
