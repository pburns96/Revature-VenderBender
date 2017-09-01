package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
import com.revature.beans.Customer;
import com.revature.services.AuthenticationService;
import com.revature.services.DataService;

@Controller
public class ManagerController {
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private static final Logger log = Logger.getLogger(ManagerController.class);
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	@RequestMapping(value="/validationManagerCheck.do")
	@ResponseBody
	public ResponseEntity<Customer> validationCheck(){
		return new ResponseEntity<Customer>((Customer) authenticationService.getSession().getAttribute("customer"),HttpStatus.OK);
	}

	@RequestMapping(value="/createConcerts.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createConcert(@RequestBody Concert concert, HttpServletRequest request){
		log.info("Creating Concert");
		dataService.createConcert(concert);
		return new ResponseEntity<S>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/createAlbums.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createAlbum(@RequestBody Album album, HttpServletRequest request){
		log.info("Creating Album");
		dataService.createAlbum(album);
		return new ResponseEntity<S>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getOrderCount.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> getOrderCount(HttpServletRequest request){
		log.info("Getting order count");
		int count = dataService.getOrderCount();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	public void setAuthenticationService(AuthenticationService authenticationService){
		this.authenticationService = authenticationService;
	}
}
