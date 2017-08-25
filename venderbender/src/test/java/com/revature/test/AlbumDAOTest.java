package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
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
		
		List<Album> albumList = api.getAlbumsByArtist("Jet");
		int testId = 0;
		for(Album item : albumList){
			Assert.assertEquals(item.getArtist(), "Jet");
		}
		
		//Test getByGenre
		albumList = api.getAlbumsByGenre("Rock");
		for(Album item : albumList){
			Assert.assertEquals(item.getGenre(), "Rock");
		}
		//Test getAll
		albumList = api.getAllAlbums();
		for(Album item : albumList){
			Assert.assertNotNull(item);
		}
		//Test getByCD
		albumList = api.getAlbumsByType(true);
		for(Album item : albumList){
			Assert.assertTrue(item.isCd());
			testId = item.getId();
		}
		//test getById
		testAlbum = api.getAlbumById(testId);
		Assert.assertEquals(new Integer(testId), new Integer(testAlbum.getId()));
		//test update
		testAlbum.setImagePath("Somepath");
		api.updateAlbum(testAlbum);
		testAlbum = api.getAlbumById(testId);
		Assert.assertEquals(testAlbum.getImagePath(), "Somepath");
		//Test delete
		api.deleteAlbum(testAlbum);
		Assert.assertNull(api.getAlbumById(testId));
	}

}
