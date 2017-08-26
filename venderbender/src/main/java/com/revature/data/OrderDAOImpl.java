package com.revature.data;

import java.util.Date;
import java.util.Set;

import javax.validation.UnexpectedTypeException;

import org.hibernate.SessionFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createOrder(Order order) throws InvalidDataAccessApiUsageException, UnexpectedTypeException {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createOrderItem(OrderItem orderItem) {
		sessionFactory.getCurrentSession().save(orderItem);
	}

	@Override
	public Set<OrderItem> getOrderItems(Order order) {
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
