package com.revature.data;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Concert;

public class ConcertDAOImpl implements ConcertDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String print(){
		return "Test";
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Concert getConcert(int id) {
		return (Concert) sessionFactory.getCurrentSession().load(Concert.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Concert> getConcertsStarting(Date date) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.gt("date", date));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Concert> getConcertsByDates(Date start, Date end) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.gt("date",start));
		query.add(Restrictions.lt("date", end));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Concert> getConcertsByBand(String band) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.eq("band",band));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Concert> getConcertsByLocation(String location) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.eq("location", location));
		return query.list();
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void createConcert(Concert concert) {
		sessionFactory.getCurrentSession().save(concert);
	}
}
