package com.revature.data;

import java.util.Date;
import java.util.Set;

import com.revature.beans.Concert;

public interface ConcertDAO {

	public Concert getConcert(int id);
	public Set<Concert> getConcertsStarting(Date date);
	public Set<Concert> getConcertsByDates(Date start, Date end);
	public Set<Concert> getConcertsByBand(String band);
	public Set<Concert> getConcertsByLocation(String location);
	
	public void createConcert(Concert concert);
}
