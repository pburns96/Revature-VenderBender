package com.revature.test;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Concert;
import com.revature.data.ConcertDAO;

public class ConcertDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	
	private ConcertDAO concertDao;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("bender.xml");
	}
	
	
	@Test
	public void testGetConcert(){
		log.debug("Testing the getConcert(int id) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
		Concert concert = (Concert)context.getBean("concert");
		concert.setDate(new Date());
		concert.setBand("testGetConcert(id)");
		concert.setLocation("Washington DC");
		concert.setPrice(50);
		concertDao.createConcert(concert);
		List<Concert> list = concertDao.getConcertsByBand("testGetConcert(id)");
		if(list.isEmpty())
			throw new IllegalArgumentException();
		concert = list.get(0);
		assertEquals(concert, concertDao.getConcert(concert.getId()));
		concertDao.deleteConcert(concert);
	}
	
	@Test
	public void testGetConcertsStarting(){
		log.debug("Testing the getConcertsStarting(Date date) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
		
		Concert concert = (Concert)context.getBean("concert");
		concert.setBand("testGetConcertsStarting(Date)");
		Calendar c = Calendar.getInstance();
		c.set(9999, 1, 1);
		concert.setDate(c.getTime());
		concert.setLocation("Washington DC");
		concert.setPrice(60);
		
		concertDao.createConcert(concert);
		List<Concert> list = concertDao.getConcertsStarting(c.getTime());
		if(list.isEmpty())
			throw new IllegalArgumentException();
		assertEquals(concert, list.get(0));
		concertDao.deleteConcert(concert);
	}
	
	@Test
	public void testGetConcertsByDates(){
		log.debug("Testing the getConcertsByDates(Date start, Date end) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
		
		Concert concert = (Concert)context.getBean("concert");
		concert.setBand("testGetConcertsStarting(Date)");
		Calendar c = Calendar.getInstance();
		c.set(1000, 1, 1);
		concert.setDate(c.getTime());
		concert.setLocation("Washington DC");
		concert.setPrice(60);
		concertDao.createConcert(concert);
		
		Calendar c1 = Calendar.getInstance();
		c1.set(999, 1, 1);
		Calendar c2 = Calendar.getInstance();
		c2.set(1001,1,1);
		
		List<Concert> list = concertDao.getConcertsByDates(c1.getTime(),c2.getTime());
		if(list.isEmpty())
			throw new IllegalArgumentException();
		assertEquals(concert,list.get(0));
		concertDao.deleteConcert(concert);
	}
	
	@Test
	public void testGetConcertsByBand(){
		log.debug("Testing the getConcertsByBand(String band) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
	}
	
	@Test
	public void testGetConcertsByLocation(){
		log.debug("Testing the getConcertsByLoaction(String location) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
		
		Concert concert = (Concert)context.getBean("concert");
		concert.setBand("testGetConcertsByLocation(location)");
		concert.setDate(new Date());
		concert.setLocation("testGetConcertsByLocation(location)");
		concert.setPrice(60);
		concertDao.createConcert(concert);
		
		List<Concert> list = concertDao.getConcertsByLocation(concert.getLocation());
		if(list.isEmpty())
			throw new IllegalArgumentException();
		assertEquals(concert,list.get(0));
		concertDao.deleteConcert(concert);
	}
	
	@Test
	public void testCreateConcert(){
		log.debug("Testing the createConcert(Concert concert) method");
		concertDao = (ConcertDAO)context.getBean("concertDAO");
		Concert concert = (Concert)context.getBean("concert");
		
		concert.setDate(new Date());
		concert.setLocation("Washington DC");
		concert.setBand("createConcert(concert)");
		concert.setPrice(50);
		concertDao.createConcert(concert);
		
		List<Concert> list = concertDao.getConcertsByBand("createConcert(concert)");
		if(list.isEmpty())
			throw new IllegalArgumentException();
		assertEquals(concert, list.get(0));
		concertDao.deleteConcert(concert);
	}
}
