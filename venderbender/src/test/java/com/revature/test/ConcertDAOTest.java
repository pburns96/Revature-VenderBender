package com.revature.test;


import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.data.ConcertDAO;

public class ConcertDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	
	private ConcertDAO concertDao;
	
	public void setConcertDao(ConcertDAO concertDao){
		log.debug("Setting the DAO!!");
		this.concertDao = concertDao;
	}
	
	@BeforeClass
	public static void beforeClass(){
		
	}
	
	
	@Test
	public void testGetConcert(){
		log.debug("Testing the getConcert(int id) method");
		//log.debug(concertDao.print());
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
