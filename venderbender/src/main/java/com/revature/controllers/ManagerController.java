package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.revature.services.DataService;

@Controller
public class ManagerController {
	
	@Autowired
	private DataService dataService;
	
	private static final Logger log = Logger.getLogger(ManagerController.class);
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	/*@RequestMapping(value="/pages/createConcerts.html")
	public String createConcertValidation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if(validateEntry(request)){
			log.info("Valid");
			//request.getRequestDispatcher("/createConcerts").forward(request, response);
			return "";
		}
		return "home";
	}*/

	@RequestMapping(value="/createConcerts.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createConcert(@RequestBody Concert concert, HttpServletRequest request){
		if(validateEntry(request)){
			log.info("Creating Concert");
			dataService.createConcert(concert);
			return new ResponseEntity<S>(HttpStatus.CREATED);
		}
		return new ResponseEntity<S>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/createAlbums.do", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public <S extends Concert> ResponseEntity<S> createAlbum(@RequestBody Album album, HttpServletRequest request){
		if(validateEntry(request)){
			log.info("Creating Album");
			dataService.createAlbum(album);
			return new ResponseEntity<S>(HttpStatus.CREATED);
		}
		return new ResponseEntity<S>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/getOrderCount.do", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> getOrderCount(HttpServletRequest request){
		if(validateEntry(request)){
			log.info("Getting order count");
			int count = dataService.getOrderCount();
			return new ResponseEntity<Integer>(count,HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(HttpStatus.FORBIDDEN);
	}
	
	public boolean validateEntry(HttpServletRequest request){
		log.info("Validating createConcert access");
		HttpSession session = request.getSession(false);
		if(session != null){
			Customer customer = (Customer) session.getAttribute("customer");
			return (customer != null && customer.isManager());
		}
		return false;
	}
}
