package com.revature.data;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
	}

	@Override
	@Transactional
	public Customer getCustomer(String username) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		query.add(Restrictions.eq("username", username));
		return (Customer) query.list().get(0);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void createCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}
	
	
}
