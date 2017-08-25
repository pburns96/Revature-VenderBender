package com.revature.data;

import java.util.Date;
import java.util.List;

import com.revature.beans.Concert;

public interface ConcertDAO {

	public Concert getConcert(int id);
	public List<Concert> getConcertsStarting(Date date);
	public List<Concert> getConcertsByDates(Date start, Date end);
	public List<Concert> getConcertsByBand(String band);
	public List<Concert> getConcertsByLocation(String location);
	
	public void createConcert(Concert concert);
	public void deleteConcert(Concert concert);
}
