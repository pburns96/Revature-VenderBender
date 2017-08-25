package com.revature.test;


import java.util.Date;

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
		//concertDao.createConcert(new Concert(new Date(), "Washington DC", "Tool", 60));
		log.debug(concertDao.getConcertsByBand("Tool"));
	}
	
	@Test
	public void testGetConcertsStarting(){
		log.debug("Testing the getConcertsStarting(Date date) method");
	}
	
	@Test
	public void testGetConcertsByDates(){
		log.debug("Testing the getConcertsByDates(Date start, Date end) method");
	}
	
	@Test
	public void testGetConcertsByBand(){
		log.debug("Testing the getConcertsByBand(String band) method");
	}
	
	@Test
	public void testGetConcertsByLocation(){
		log.debug("Testing the getConcertsByLoaction(String location) method");
	}
	
	@Test
	public void testCreateConcert(){
		log.debug("Testing the createConcert(Concert concert) method");
	}
}
