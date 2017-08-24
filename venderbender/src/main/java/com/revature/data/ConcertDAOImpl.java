package com.revature.data;

import java.util.Date;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.revature.beans.Concert;

public class ConcertDAOImpl implements ConcertDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Concert getConcert(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Concert> getConcertsStarting(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Concert> getConcertsByDates(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Concert> getConcertsByBand(String band) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Concert> getConcertsByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createConcert(Concert concert) {
		// TODO Auto-generated method stub
		
	}
	
	
}
