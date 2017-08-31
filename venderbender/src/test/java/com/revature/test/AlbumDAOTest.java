package com.revature.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.beans.Album;
import com.revature.data.AlbumDAO;

public class AlbumDAOTest {
	private static final Logger log = Logger.getLogger(ConcertDAOTest.class);
	private AlbumDAO albumDAO;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context =  new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml");
	}
	@Test
	public void testCreate(){
		log.info("»Testing Album create...");
		albumDAO = (AlbumDAO) context.getBean("albumDAO");
		Album testAlbum = (Album) context.getBean("album");
		testAlbum.setArtist("Red Hot Chili Peppers");
		testAlbum.setCd((byte)0);
		testAlbum.setTitle("Stadium Arcadium");
		testAlbum.setPrice(8.92d);
		testAlbum.setYear((short)2006);
		testAlbum.setTracks("01-Dani California");
		testAlbum.setGenre("Rock");
		albumDAO.createAlbum(testAlbum);
		log.info("Album created...");
		log.info("»Test findByArtist");
		
		List<Album> albumList = albumDAO.getAlbumsByArtist("Red Hot Chili Peppers");
		int testId = 0;
		for(Album item : albumList){
			log.info("getAlbumsByArtist(\"Red Hot Chili Peppers\") = " + item.getArtist());
			Assert.assertEquals(item.getArtist(), "Red Hot Chili Peppers");
		}
		
		log.info("»Test getByGenre");
		albumList = albumDAO.getAlbumsByGenre("Rock");
		for(Album item : albumList){
			log.info("getAlbumsByGenre(\"Rock\") = " + item.getGenre());
			Assert.assertEquals(item.getGenre(), "Rock");
		}
		log.info("»Test getAll");
		albumList = albumDAO.getAllAlbums();
		for(Album item : albumList){
			Assert.assertNotNull(item);
			log.info("getAllAlbums() = " + item.getArtist());
		}
		log.info("»Test getByCD");
		albumList = albumDAO.getAlbumsByType((byte)0);
		for(Album item : albumList){
			log.info("getAlbumsByType((byte)0) = " + item.getCd());
			Assert.assertEquals(new Byte((byte) 0),new Byte(item.getCd()) );
			testId = item.getId();
			log.info("id from the album in the list is = " + testId);
		}
		log.info("test getById");
		testAlbum = albumDAO.getAlbumById(testId);
		Assert.assertEquals(new Integer(testId), new Integer(testAlbum.getId()));
		log.info("»test update");
		testAlbum.setImagePath("Somepath");
		albumDAO.updateAlbum(testAlbum);
		testAlbum = albumDAO.getAlbumById(testId);
		Assert.assertEquals(testAlbum.getImagePath(), "Somepath");
		log.info("Path from updated album = " + testAlbum.getImagePath());
		log.info("»Test delete");
		albumDAO.deleteAlbum(testAlbum);
		Assert.assertNull(albumDAO.getAlbumById(testId));
	}
}