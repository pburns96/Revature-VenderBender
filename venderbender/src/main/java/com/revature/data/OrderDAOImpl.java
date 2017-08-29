package com.revature.data;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<OrderItem> getOrderItems(Order order) {
		return sessionFactory.getCurrentSession().createCriteria(OrderItem.class).add(Restrictions.eq("order.id", order.getId())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Order> getOrders(Customer customer) {
		return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("owner.id", customer.getId())).list();
	}


	@Override
	@Transactional
	public void updateOrderItem(OrderItem item) {
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	@Transactional
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
	}

	@Override
	@Transactional
	public void deleteOrderItem(OrderItem item) {
		sessionFactory.getCurrentSession().delete(item);
	}
	
	
}
