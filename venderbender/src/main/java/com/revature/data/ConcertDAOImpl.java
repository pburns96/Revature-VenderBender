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

	@Override
	@Transactional
	public Concert getConcert(int id) {
		return (Concert) sessionFactory.getCurrentSession().get(Concert.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Concert> getConcertsStarting(Date date) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.ge("date", date));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Concert> getConcertsByDates(Date start, Date end) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.ge("date",start));
		query.add(Restrictions.le("date", end));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Concert> getConcertsByBand(String band) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.ilike("band","%"+band+"%"));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Concert> getConcertsByLocation(String location) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Concert.class);
		query.add(Restrictions.eq("location", location));
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Concert> getAllConcerts(){
		return sessionFactory.getCurrentSession().createCriteria(Concert.class).list();
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void createConcert(Concert concert) {
		sessionFactory.getCurrentSession().save(concert);
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deleteConcert(Concert concert) {
		sessionFactory.getCurrentSession().delete(concert);
	}
	
}
