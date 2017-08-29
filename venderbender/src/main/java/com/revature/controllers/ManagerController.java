package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Album;
import com.revature.beans.Concert;
import com.revature.services.DataService;

@Controller
public class ManagerController {
	
	@Autowired
	private DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	@RequestMapping(value="/createConcerts.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createConcert(@RequestBody Concert concert){
		System.out.println("Creating Concert");
		System.out.println(concert);
		dataService.createConcert(concert);
		return new ResponseEntity<S>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/createAlbums.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createAlbum(@RequestBody Album album){
		System.out.println("Creating Concert");
		System.out.println(album);
		dataService.createAlbum(album);
		return new ResponseEntity<S>(HttpStatus.CREATED);
	}
}
