package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Album;
import com.revature.beans.Concert;
import com.revature.services.DataService;

@Controller
public class CustomerViewController {
	@Autowired
	private DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	@RequestMapping(value="/findAlbum{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Album> getAlbumById(@PathVariable int id){
		return new ResponseEntity<Album>(dataService.getAlbumById(id), HttpStatus.FOUND);	
	}
	@RequestMapping(value="/AlbumByArtist.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Album>> getAlbumsByArtist(@RequestBody String artist){
		return new ResponseEntity<List<Album>>(dataService.getAlbumsByArtist(artist), HttpStatus.OK);
		
	}
	@RequestMapping(value="/AlbumsAll.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Album>> getAllAlbums(){
		return new ResponseEntity<List<Album>>(dataService.getAllAlbums(), HttpStatus.OK);
		
	}
	@RequestMapping(value="/AlbumsByGenre.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Album>> getAlbumsByGenre(@RequestBody String genre){
		return new ResponseEntity<List<Album>>(dataService.getAlbumsByGenre(genre), HttpStatus.OK);
		
	}
	@RequestMapping(value="/AlbumsByType.do", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Album>> getAlbumsByType(@RequestBody int type){
		return new ResponseEntity<List<Album>>(dataService.getAlbumsByType((byte)type), HttpStatus.OK);
		
	}
	@RequestMapping(value="/ConcertsAll.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Concert>> getAllConcerts(@RequestBody int type){
		return new ResponseEntity<List<Concert>>(dataService.getAllConcerts(), HttpStatus.OK);
		
	}

}
