package com.revature.services;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.controllers.OrderController;

public class ApplicationContextService {

	private static ApplicationContext context;
	private static final Logger log = Logger.getLogger(ApplicationContextService.class);
	
	public static ApplicationContext getContext(){
		if(context != null)
			return context;
		else{
			log.debug("Creating Application Context");
			context =  new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml"); 
			return context;
		}
	}
}
