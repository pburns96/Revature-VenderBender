package com.revature.test;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Album;
import com.revature.data.AlbumDAO;

public class AlbumDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	private AlbumDAO api;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("bender.xml");
	}
	@Test
	public void testCreate(){
		log.debug("Testing Album create...");
		api = (AlbumDAO) context.getBean("albumDAO");
		Album testAlbum = (Album) context.getBean("album");
		testAlbum.setArtist("Jet");
		testAlbum.setCd(true);
		testAlbum.setTitle("Get Born");
		testAlbum.setPrice(12.49);
		testAlbum.setYear((short)2003);
		testAlbum.setTracks("01-Some Track,02-Some Other Track,03-Are You Gunna Be My Girl");
		testAlbum.setGenre("Rock");
		api.createAlbum(testAlbum);
		
		//Test findByArtist
		
		
	}

}
