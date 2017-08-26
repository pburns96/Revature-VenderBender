package com.revature.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Album;
import com.revature.data.AlbumDAO;

public class AlbumDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	private AlbumDAO albumDAO;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("bender.xml");
	}
	@Test
	public void testCreate(){
		log.debug("Testing Album create...");
		albumDAO = (AlbumDAO) context.getBean("albumDAO");
		Album testAlbum = (Album) context.getBean("album");
		testAlbum.setArtist("Fuel");
		testAlbum.setCd((byte)0);
		testAlbum.setTitle("Hemorrhage (In My Hands)");
		testAlbum.setPrice(5.17d);
		testAlbum.setYear((short)2000);
		testAlbum.setTracks("01-Hemorrhage");
		testAlbum.setGenre("Rock");
		albumDAO.createAlbum(testAlbum);
		log.debug("Album created...");
		//Test findByArtist
		
		List<Album> albumList = albumDAO.getAlbumsByArtist("Fuel");
		int testId = 0;
		for(Album item : albumList){
			log.debug(item.getArtist());
			Assert.assertEquals(item.getArtist(), "Fuel");
		}
		
		//Test getByGenre
		albumList = albumDAO.getAlbumsByGenre("Rock");
		for(Album item : albumList){
			log.debug(item.getGenre());
			Assert.assertEquals(item.getGenre(), "Rock");
		}
		//Test getAll
		albumList = albumDAO.getAllAlbums();
		for(Album item : albumList){
			Assert.assertNotNull(item);
			log.debug(item.getArtist());
		}
		//Test getByCD
		albumList = albumDAO.getAlbumsByType((byte)0);
		for(Album item : albumList){
			log.debug("   ————»»»" + item.getCd());
			Assert.assertEquals(new Byte((byte) 0),new Byte(item.getCd()) );
			testId = item.getId();
			log.debug(testId);
		}
		//test getById
		testAlbum = albumDAO.getAlbumById(testId);
		Assert.assertEquals(new Integer(testId), new Integer(testAlbum.getId()));
		//test update
		testAlbum.setImagePath("Somepath");
		albumDAO.updateAlbum(testAlbum);
		testAlbum = albumDAO.getAlbumById(testId);
		Assert.assertEquals(testAlbum.getImagePath(), "Somepath");
		//Test delete
		albumDAO.deleteAlbum(testAlbum);
		Assert.assertNull(albumDAO.getAlbumById(testId));
	}

}
